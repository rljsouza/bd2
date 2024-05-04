package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.entity.AccessDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessDataRepository extends JpaRepository<AccessDataEntity, Long> {
    Optional<AccessDataEntity> findByUsername(String username);
}
