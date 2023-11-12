package com.rogersentongo.organizationservice.repository;

import com.rogersentongo.organizationservice.dto.OrganizationDto;
import com.rogersentongo.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
