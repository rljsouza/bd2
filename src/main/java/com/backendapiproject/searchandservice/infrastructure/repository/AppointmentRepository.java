package com.backendapiproject.searchandservice.infrastructure.repository;

import com.backendapiproject.searchandservice.infrastructure.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
