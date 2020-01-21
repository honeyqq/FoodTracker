package ua.com.foodtrackerfinal.mapper;

import org.springframework.stereotype.Component;
import ua.com.foodtrackerfinal.dto.RoleDto;
import ua.com.foodtrackerfinal.entity.Role;

import javax.management.relation.RoleNotFoundException;

@Component
public class RoleEntityToRoleDto implements Mapper<Role, RoleDto> {

    @Override
    public RoleDto transform(Role from) throws RoleNotFoundException {
        if (from == null) {
            return null;
        }
        String roleName = from.getRoleName();
        RoleDto roleDto;
        switch (roleName) {
            case "ADMIN":
                roleDto = RoleDto.ADMIN;
                roleDto.setId(from.getId());
                break;
            case "USER":
                roleDto = RoleDto.USER;
                roleDto.setId(from.getId());
                break;
            default:
                throw new RoleNotFoundException("Your role does not exist!");
        }
        return roleDto;
    }

}
