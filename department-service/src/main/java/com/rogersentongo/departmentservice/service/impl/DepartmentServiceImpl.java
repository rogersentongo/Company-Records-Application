package com.rogersentongo.departmentservice.service.impl;

import com.rogersentongo.departmentservice.dto.DepartmentDto;
import com.rogersentongo.departmentservice.entity.Department;
import com.rogersentongo.departmentservice.repository.DepartmentRespository;
import com.rogersentongo.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRespository departmentRespository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert DepartmentDTO to department JPA entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );


        //Save the department jpa entity
        Department savedDepartment = departmentRespository.save(department);

        //convert department jpa entity back to department dto and return it
        DepartmentDto returnedDepartment = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()

        );
        return returnedDepartment;

    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRespository.findByDepartmentCode(departmentCode);

        DepartmentDto returnedDepartment = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return returnedDepartment;

    }
}
