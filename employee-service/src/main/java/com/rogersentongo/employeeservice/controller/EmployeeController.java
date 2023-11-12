package com.rogersentongo.employeeservice.controller;

import com.rogersentongo.employeeservice.dto.APIResponseDto;
import com.rogersentongo.employeeservice.dto.EmployeeDto;
import com.rogersentongo.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Employee Service - Employee Controller",
        description="Employee Controller Exposes REST APIs for Employee Service"
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Save Employee REST API
    @Operation(
            summary="Save Employee REST API",
            description = "Save Employee REST API is used to save Employee object in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description="HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @Operation(
            summary="Get Employee REST API",
            description = "Get Employee REST API is used to get Employee object in a DB"
    )
    @ApiResponse(
            responseCode = "200",
            description="HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }


}
