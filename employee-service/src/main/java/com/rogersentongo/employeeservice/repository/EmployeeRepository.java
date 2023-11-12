package com.rogersentongo.employeeservice.repository;

import com.rogersentongo.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
