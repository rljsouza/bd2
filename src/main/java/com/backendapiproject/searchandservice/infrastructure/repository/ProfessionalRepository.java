package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.entity.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {
}
