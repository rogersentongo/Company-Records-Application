package com.rogersentongo.organizationservice.service.impl;

import com.rogersentongo.organizationservice.dto.OrganizationDto;
import com.rogersentongo.organizationservice.entity.Organization;
import com.rogersentongo.organizationservice.mapper.OrganizationMapper;
import com.rogersentongo.organizationservice.repository.OrganizationRepository;
import com.rogersentongo.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganizationDto(OrganizationDto organizationDto) {
        //Convert organizationDto to organization JPA
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        //Save to database
        Organization savedOrganized = organizationRepository.save(organization);

        OrganizationDto savedOrganizedDto = OrganizationMapper.mapToOrganizationDto(savedOrganized);

        return savedOrganizedDto;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);

        return organizationDto;
    }
}
