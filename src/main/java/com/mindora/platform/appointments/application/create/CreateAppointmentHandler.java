package com.mindora.platform.appointments.application.create;

import com.mindora.platform.appointments.domain.model.*;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentHandler {

    private final AppointmentRepository repository;

    public CreateAppointmentHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public AppointmentCreatedResponse execute(CreateAppointmentCommand cmd) {

        Appointment appointment = new Appointment(
                AppointmentId.newId(),
                cmd.psychologistId(),
                cmd.employeeId(),
                cmd.dateTime(),
                AppointmentStatus.SCHEDULED
        );

        repository.save(appointment);

        return new AppointmentCreatedResponse(appointment.getId().value());
    }
}
