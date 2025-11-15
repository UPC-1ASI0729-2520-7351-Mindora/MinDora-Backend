package com.mindora.platform.appointments.application.delete;

import com.mindora.platform.appointments.domain.model.AppointmentId;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteAppointmentHandler {

    private final AppointmentRepository repository;

    public DeleteAppointmentHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public void execute(DeleteAppointmentCommand cmd) {
        repository.deleteById(new AppointmentId(cmd.id()));
    }
}
