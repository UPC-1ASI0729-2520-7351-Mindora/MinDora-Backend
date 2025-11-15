package com.mindora.platform.appointments.application.create;

import java.time.LocalDateTime;

public record CreateAppointmentCommand(
        Long psychologistId,
        Long employeeId,
        LocalDateTime dateTime
) {}
