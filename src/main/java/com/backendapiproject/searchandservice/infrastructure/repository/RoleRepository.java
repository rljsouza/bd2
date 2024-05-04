package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.entity.RoleEntity;
import com.backendapiproject.searchandservice.infrastructure.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity>  findByRoleType(RoleType roleType);
}
