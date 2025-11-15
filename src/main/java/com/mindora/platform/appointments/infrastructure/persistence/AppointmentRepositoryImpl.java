package com.mindora.platform.appointments.infrastructure.persistence;

import com.mindora.platform.appointments.domain.model.*;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private final AppointmentJpaRepository jpa;

    public AppointmentRepositoryImpl(AppointmentJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Appointment save(Appointment appointment) {

        AppointmentJpaEntity entity = new AppointmentJpaEntity();
        entity.setId(appointment.getId().value());
        entity.setPsychologistId(appointment.getPsychologistId());
        entity.setEmployeeId(appointment.getEmployeeId());
        entity.setDateTime(appointment.getDateTime());
        entity.setStatus(appointment.getStatus());

        jpa.save(entity);
        return appointment;
    }

    @Override
    public Optional<Appointment> findById(AppointmentId id) {
        return jpa.findById(id.value())
                .map(this::toDomain);
    }

    @Override
    public void deleteById(AppointmentId id) {
        jpa.deleteById(id.value());
    }

    @Override
    public List<Appointment> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public List<Appointment> findByPsychologistId(Long psychologistId) {
        return jpa.findByPsychologistId(psychologistId).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Appointment> findByEmployeeId(Long employeeId) {
        return jpa.findByEmployeeId(employeeId).stream().map(this::toDomain).toList();
    }

    private Appointment toDomain(AppointmentJpaEntity j) {
        return new Appointment(
                new AppointmentId(j.getId()),
                j.getPsychologistId(),
                j.getEmployeeId(),
                j.getDateTime(),
                j.getStatus()
        );
    }
}
