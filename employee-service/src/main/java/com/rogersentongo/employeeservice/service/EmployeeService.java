package com.rogersentongo.employeeservice.service;

import com.rogersentongo.employeeservice.dto.APIResponseDto;
import com.rogersentongo.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
