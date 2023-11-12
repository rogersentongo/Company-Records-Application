package com.rogersentongo.departmentservice.repository;

import com.rogersentongo.departmentservice.dto.DepartmentDto;
import com.rogersentongo.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
