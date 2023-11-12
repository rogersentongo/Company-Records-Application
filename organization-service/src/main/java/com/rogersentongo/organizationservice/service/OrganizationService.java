package com.rogersentongo.organizationservice.service;

import com.rogersentongo.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganizationDto(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);

}
