package org.ogleh.departmentservice.mappers;

import org.ogleh.departmentservice.dao.DepartmentRequest;
import org.ogleh.departmentservice.dto.DepartmentDto;
import org.ogleh.departmentservice.entities.Department;

public class DepartmentMapper {

    static public DepartmentDto departmentDtoDepartment(Department department) {
        return DepartmentDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .departmentAddress(department.getDepartmentAddress())
                .build();
    }

    static public Department departmentDoToDepartment(DepartmentRequest request) {
        return Department.builder()
                .departmentName(request.departmentName())
                .departmentAddress(request.departmentAddress())
                .build();
    }
}
