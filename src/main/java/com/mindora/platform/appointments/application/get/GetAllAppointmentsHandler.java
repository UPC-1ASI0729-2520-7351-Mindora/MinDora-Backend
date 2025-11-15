package com.mindora.platform.appointments.application.get;

import com.mindora.platform.appointments.domain.model.Appointment;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAppointmentsHandler {

    private final AppointmentRepository repository;

    public GetAllAppointmentsHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> execute(GetAllAppointmentsQuery query) {
        return repository.findAll();
    }
}
