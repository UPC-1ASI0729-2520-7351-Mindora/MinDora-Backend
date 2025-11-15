package com.mindora.platform.appointments.application.update;

import com.mindora.platform.appointments.domain.model.Appointment;
import com.mindora.platform.appointments.domain.model.AppointmentId;
import com.mindora.platform.appointments.domain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ChangeAppointmentStatusHandler {

    private final AppointmentRepository repository;

    public ChangeAppointmentStatusHandler(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment execute(ChangeAppointmentStatusCommand cmd) {
        Appointment appointment = repository.findById(new AppointmentId(cmd.appointmentId()))
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        switch (cmd.action()) {
            case START -> appointment.start();
            case CONFIRM -> appointment.confirm();
            case COMPLETE -> appointment.complete();
            case CANCEL -> appointment.cancel();
        }

        return repository.save(appointment);
    }
}
