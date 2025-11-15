package com.mindora.platform.appointments.application.update;

import com.mindora.platform.appointments.domain.model.Appointment;
import com.mindora.platform.appointments.domain.model.AppointmentId;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class RescheduleAppointmentHandler {

    private final AppointmentRepository repository;

    public RescheduleAppointmentHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment execute(RescheduleAppointmentCommand cmd) {
        Appointment appointment = repository.findById(new AppointmentId(cmd.appointmentId()))
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        appointment.reschedule(cmd.newDateTime());

        return repository.save(appointment);
    }
}
