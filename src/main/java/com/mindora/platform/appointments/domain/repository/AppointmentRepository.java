package com.mindora.platform.appointments.domain.repository;

import com.mindora.platform.appointments.domain.model.Appointment;
import com.mindora.platform.appointments.domain.model.AppointmentId;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(AppointmentId id);
    void deleteById(AppointmentId id);

    List<Appointment> findAll();
    List<Appointment> findByPsychologistId(Long psychologistId);
    List<Appointment> findByEmployeeId(Long employeeId);
}
