package com.mindora.platform.appointments.application.update;

import java.util.UUID;

public record ChangeAppointmentStatusCommand(UUID appointmentId, StatusAction action) {

    public enum StatusAction {
        START,
        CONFIRM,
        COMPLETE,
        CANCEL
    }
}
