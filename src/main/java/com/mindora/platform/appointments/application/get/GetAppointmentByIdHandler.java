package com.mindora.platform.appointments.application.get;

import com.mindora.platform.appointments.domain.model.*;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAppointmentByIdHandler {

    private final AppointmentRepository repository;

    public GetAppointmentByIdHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment execute(GetAppointmentByIdQuery query) {
        return repository.findById(new AppointmentId(query.id()))
                .orElse(null);
    }
}
