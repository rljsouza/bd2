package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.entity.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM professional_service WHERE service_id = :serviceId", nativeQuery = true)
    void deleteFromProfessionalService(Long serviceId);
}

