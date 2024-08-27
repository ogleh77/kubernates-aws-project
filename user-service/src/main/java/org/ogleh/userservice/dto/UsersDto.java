package org.ogleh.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private int userId;
    private String username;
    private int departmentId;
    private String departmentName;
    private String departmentAddress;
}
