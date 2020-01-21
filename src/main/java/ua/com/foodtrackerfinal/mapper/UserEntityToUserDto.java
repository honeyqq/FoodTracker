package ua.com.foodtrackerfinal.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.foodtrackerfinal.dto.UserDto;
import ua.com.foodtrackerfinal.entity.User;

import javax.management.relation.RoleNotFoundException;

@Component
public class UserEntityToUserDto implements Mapper<User, UserDto> {

    private RoleEntityToRoleDto roleEntityToRoleDto;

    @Autowired
    public UserEntityToUserDto(RoleEntityToRoleDto roleEntityToRoleDto) {
        this.roleEntityToRoleDto = roleEntityToRoleDto;
    }

    @Override
    public UserDto transform(User from) throws RoleNotFoundException {
        if (from == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(from.getId());
        userDto.setUsername(from.getUsername());
        userDto.setPassword(from.getPassword());
        userDto.setRole(roleEntityToRoleDto.transform(from.getRole()));
        return userDto;
    }
}
