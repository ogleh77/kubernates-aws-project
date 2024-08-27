package org.ogleh.departmentservice.controllers;

import lombok.RequiredArgsConstructor;
import org.ogleh.departmentservice.dao.DepartmentRequest;
import org.ogleh.departmentservice.dto.DepartmentDto;
import org.ogleh.departmentservice.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")

public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<?>createDepartmet(@RequestBody DepartmentRequest request) {
        departmentService.createDepartment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Department created ");
    }



    @GetMapping("/{departmentId}")
    public DepartmentDto getDepartment(@PathVariable("departmentId") int departmentID) {
        return departmentService.getDepartment(departmentID);
    }
}
