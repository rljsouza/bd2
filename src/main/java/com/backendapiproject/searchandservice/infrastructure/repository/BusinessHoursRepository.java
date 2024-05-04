package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.entity.BusinessHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BusinessHoursRepository extends JpaRepository<BusinessHoursEntity, Long> {
}
