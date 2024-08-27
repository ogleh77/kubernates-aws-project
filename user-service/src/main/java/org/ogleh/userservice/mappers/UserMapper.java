package org.ogleh.userservice.mappers;

import org.ogleh.userservice.dao.UserRequest;
import org.ogleh.userservice.dto.UsersDto;
import org.ogleh.userservice.entities.Department;
import org.ogleh.userservice.entities.Users;

public class UserMapper {

    static public UsersDto userAndDepartmentToUserDto(Users user, Department department) {
        return UsersDto.builder()
                .userId(user.getUserId())
                .departmentAddress(department.getDepartmentAddress() != null ? department.getDepartmentAddress() : "No address available")
                .username(user.getUsername())
                .departmentId(department.getDepartmentId() != 0 ? department.getDepartmentId() : 0)
                .departmentName(department.getDepartmentName() != null ? department.getDepartmentName() : "No name available")
                .build();
    }


    static public Users userDtoToUser(UserRequest request) {
        return Users.builder()
                .departmentId(request.departmentId())
                .username(request.username())
                .build();
    }

}
