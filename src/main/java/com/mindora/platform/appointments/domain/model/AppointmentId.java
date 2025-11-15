package com.mindora.platform.appointments.domain.model;

import java.util.UUID;

public record AppointmentId(UUID value) {

    public static AppointmentId newId() {
        return new AppointmentId(UUID.randomUUID());
    }
}
