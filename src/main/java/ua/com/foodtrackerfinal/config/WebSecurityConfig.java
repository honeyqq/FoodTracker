package ua.com.foodtrackerfinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                    .disable()
//                .authorizeRequests()
//                    //Доступ только для не зарегистрированных пользователей
//                    .antMatchers("/registration").not().fullyAuthenticated()
//                    //Доступ только для пользователей с ролью Администратор
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .antMatchers("/news").hasRole("USER")
//                    //Доступ разрешен всем пользователей
//                    .antMatchers("/", "/resources/**").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                    //Настройка для входа в систему
//                    .formLogin()
//                    .loginPage("/login")
//                    //Перенарпавление на главную страницу после успешного входа
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .permitAll()
//                    .logoutSuccessUrl("/");
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/registration", "/login", "/login/user").permitAll()
//                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated();
//                .and()
//                .formLogin()
//                .loginPage("/login/user")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
