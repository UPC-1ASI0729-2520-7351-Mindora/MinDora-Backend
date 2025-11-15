package com.mindora.platform.appointments.application.update;

import java.time.LocalDateTime;
import java.util.UUID;

public record RescheduleAppointmentCommand(UUID appointmentId, LocalDateTime newDateTime) {}
