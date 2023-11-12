package com.rogersentongo.employeeservice.service;

import com.rogersentongo.employeeservice.dto.DepartmentDto;
import com.rogersentongo.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

    //Build Get Department REST API
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

    @GetMapping("api/organizations/{organization-code}")
    OrganizationDto getOrganization(@PathVariable("organization-code") String organizationCode);
}
