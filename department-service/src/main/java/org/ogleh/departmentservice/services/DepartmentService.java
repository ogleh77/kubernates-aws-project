package org.ogleh.departmentservice.services;

import lombok.RequiredArgsConstructor;
import org.ogleh.departmentservice.dao.DepartmentRequest;
import org.ogleh.departmentservice.dto.DepartmentDto;
import org.ogleh.departmentservice.entities.Department;
import org.ogleh.departmentservice.mappers.DepartmentMapper;
import org.ogleh.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public void createDepartment(DepartmentRequest request) {
        Department department = Department.builder()
                .departmentName(request.departmentName())
                .departmentAddress(request.departmentAddress())
                .build();
        departmentRepository.save(department);
    }

    public DepartmentDto getDepartment(int departmentID) {

        Optional<Department> department = departmentRepository.findById(departmentID);

        return department.map(DepartmentMapper::departmentDtoDepartment).orElse(null);
    }
}
