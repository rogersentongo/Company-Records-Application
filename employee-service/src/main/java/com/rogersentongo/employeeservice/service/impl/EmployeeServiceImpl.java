package com.rogersentongo.employeeservice.service.impl;

import com.rogersentongo.employeeservice.dto.APIResponseDto;
import com.rogersentongo.employeeservice.dto.DepartmentDto;
import com.rogersentongo.employeeservice.dto.EmployeeDto;
import com.rogersentongo.employeeservice.dto.OrganizationDto;
import com.rogersentongo.employeeservice.entity.Employee;
import com.rogersentongo.employeeservice.mapper.EmployeeMapper;
import com.rogersentongo.employeeservice.repository.EmployeeRepository;
import com.rogersentongo.employeeservice.service.APIClient;
import com.rogersentongo.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private APIClient apiClient;
    //private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        //Using RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity =
//                restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);



        //Using WebClient bean
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        //Using Open Feign
//        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
//        OrganizationDto organizationDto = apiClient.getOrganization(employee.getOrganizationCode());


        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();

        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }
}
