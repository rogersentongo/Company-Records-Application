package com.rogersentongo.departmentservice.controller;

import com.rogersentongo.departmentservice.dto.DepartmentDto;
import com.rogersentongo.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Department Service - Department Controller",
        description="Department Controller Exposes REST APIs for Department Service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Save Department REST API
    @Operation(
            summary="Save Department REST API",
            description = "Save Department REST API is used to save Department object in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description="HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //Build Get Department REST API
    @Operation(
            summary="GET Department REST API",
            description = "GET Department REST API is used to get department object from a DB"
    )
    @ApiResponse(
            responseCode = "200",
            description="HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto =departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
