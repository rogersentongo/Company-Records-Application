package com.rogersentongo.organizationservice.controller;

import com.rogersentongo.organizationservice.dto.OrganizationDto;
import com.rogersentongo.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Organization Service - Organization Controller",
        description="Organization Controller Exposes REST APIs for Organization Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    //BUILD Save Organization REST API
    @Operation(
            summary="Save Organization REST API",
            description = "Save Organization REST API is used to save Organization object in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description="HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto = organizationService.saveOrganizationDto(organizationDto);


        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }

    //BUILD Get Organization by Code REST API
    @Operation(
            summary="GET Organization REST API",
            description = "GET Organization REST API is used to get Organization object from a DB"
    )
    @ApiResponse(
            responseCode = "200",
            description="HTTP Status 200 SUCCESS"
    )
    @GetMapping("{orgCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("orgCode") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

        return ResponseEntity.ok(organizationDto);
    }

}
