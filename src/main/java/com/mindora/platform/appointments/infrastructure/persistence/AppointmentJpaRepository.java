package com.mindora.platform.appointments.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentJpaEntity, UUID> {

    List<AppointmentJpaEntity> findByPsychologistId(Long psychologistId);
    List<AppointmentJpaEntity> findByEmployeeId(Long employeeId);
}
