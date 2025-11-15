package com.mindora.platform.appointments.domain.model;

import java.time.LocalDateTime;

public class Appointment {

    private final AppointmentId id;
    private final Long psychologistId;
    private final Long employeeId;
    private LocalDateTime dateTime;
    private AppointmentStatus status;

    public Appointment(AppointmentId id,
                       Long psychologistId,
                       Long employeeId,
                       LocalDateTime dateTime,
                       AppointmentStatus status) {
        this.id = id;
        this.psychologistId = psychologistId;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.status = status;
    }

    public AppointmentId getId() { return id; }
    public Long getPsychologistId() { return psychologistId; }
    public Long getEmployeeId() { return employeeId; }
    public LocalDateTime getDateTime() { return dateTime; }
    public AppointmentStatus getStatus() { return status; }

    // Comportamiento de dominio

    public void reschedule(LocalDateTime newDateTime) {
        if (status == AppointmentStatus.COMPLETED || status == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Cannot reschedule a completed or cancelled appointment");
        }
        this.dateTime = newDateTime;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void start() {
        if (status != AppointmentStatus.SCHEDULED) {
            throw new IllegalStateException("Only scheduled appointments can be started");
        }
        this.status = AppointmentStatus.STARTED;
    }

    public void confirm() {
        if (status != AppointmentStatus.STARTED) {
            throw new IllegalStateException("Only started appointments can be confirmed");
        }
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void complete() {
        if (status != AppointmentStatus.CONFIRMED) {
            throw new IllegalStateException("Only confirmed appointments can be completed");
        }
        this.status = AppointmentStatus.COMPLETED;
    }

    public void cancel() {
        if (status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Cannot cancel a completed appointment");
        }
        this.status = AppointmentStatus.CANCELLED;
    }
}
