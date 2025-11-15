package com.mindora.platform.appointments.application.get;

import com.mindora.platform.appointments.domain.model.Appointment;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAppointmentsByEmployeeIdHandler {

    private final AppointmentRepository repository;

    public GetAppointmentsByEmployeeIdHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> execute(GetAppointmentsByEmployeeIdQuery query) {
        return repository.findByEmployeeId(query.employeeId());
    }
}
