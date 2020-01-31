package ua.com.foodtrackerfinal.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ua.com.foodtrackerfinal.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = findRedirectURLForUserRole(authentication);

        if (response.isCommitted()) {
            log.info("Can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String findRedirectURLForUserRole(Authentication authentication) {
        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }

        if (isAdmin(roles)) {
            url = "/admin/";
        } else if (isUser(roles)) {
            url = "/user/";
        } else {
            url = "/index";
        }
        log.info("determineTargetUrl ==> " + url);
        return url;
    }

    /**
     * Check is user have user authority
     *
     * @param roles
     * @return
     */
    private boolean isUser(List<String> roles) {
        return roles.contains(Role.USER.getAuthority());
    }

    /**
     * Check is user have admin authority
     *
     * @param roles
     * @return
     */
    private boolean isAdmin(List<String> roles) {
        return roles.contains(Role.ADMIN.getAuthority());
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

}
