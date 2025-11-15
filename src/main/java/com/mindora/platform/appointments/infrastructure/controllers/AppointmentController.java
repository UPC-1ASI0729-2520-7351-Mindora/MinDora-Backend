package com.mindora.platform.appointments.infrastructure.controllers;

import com.mindora.platform.appointments.application.create.*;
import com.mindora.platform.appointments.application.delete.*;
import com.mindora.platform.appointments.application.get.*;
import com.mindora.platform.appointments.application.update.*;
import com.mindora.platform.appointments.domain.model.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final CreateAppointmentHandler createHandler;
    private final GetAppointmentByIdHandler getByIdHandler;
    private final GetAllAppointmentsHandler getAllHandler;
    private final GetAppointmentsByPsychologistIdHandler getByPsychologistHandler;
    private final GetAppointmentsByEmployeeIdHandler getByEmployeeHandler;
    private final RescheduleAppointmentHandler rescheduleHandler;
    private final ChangeAppointmentStatusHandler statusHandler;
    private final DeleteAppointmentHandler deleteHandler;

    public AppointmentController(
            CreateAppointmentHandler createHandler,
            GetAppointmentByIdHandler getByIdHandler,
            GetAllAppointmentsHandler getAllHandler,
            GetAppointmentsByPsychologistIdHandler getByPsychologistHandler,
            GetAppointmentsByEmployeeIdHandler getByEmployeeHandler,
            RescheduleAppointmentHandler rescheduleHandler,
            ChangeAppointmentStatusHandler statusHandler,
            DeleteAppointmentHandler deleteHandler
    ) {
        this.createHandler = createHandler;
        this.getByIdHandler = getByIdHandler;
        this.getAllHandler = getAllHandler;
        this.getByPsychologistHandler = getByPsychologistHandler;
        this.getByEmployeeHandler = getByEmployeeHandler;
        this.rescheduleHandler = rescheduleHandler;
        this.statusHandler = statusHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping
    public ResponseEntity<AppointmentCreatedResponse> create(@RequestBody CreateAppointmentCommand request) {
        return ResponseEntity.ok(createHandler.execute(request));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(getAllHandler.execute(new GetAllAppointmentsQuery()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdHandler.execute(new GetAppointmentByIdQuery(id)));
    }

    @PutMapping("/{id}/reschedule")
    public ResponseEntity<Appointment> reschedule(
            @PathVariable UUID id,
            @RequestParam("dateTime") String dateTimeIso
    ) {
        LocalDateTime newDateTime = LocalDateTime.parse(dateTimeIso);
        return ResponseEntity.ok(
                rescheduleHandler.execute(new RescheduleAppointmentCommand(id, newDateTime))
        );
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<Appointment> start(@PathVariable UUID id) {
        return ResponseEntity.ok(
                statusHandler.execute(
                        new ChangeAppointmentStatusCommand(id, ChangeAppointmentStatusCommand.StatusAction.START)
                )
        );
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Appointment> confirm(@PathVariable UUID id) {
        return ResponseEntity.ok(
                statusHandler.execute(
                        new ChangeAppointmentStatusCommand(id, ChangeAppointmentStatusCommand.StatusAction.CONFIRM)
                )
        );
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<Appointment> complete(@PathVariable UUID id) {
        return ResponseEntity.ok(
                statusHandler.execute(
                        new ChangeAppointmentStatusCommand(id, ChangeAppointmentStatusCommand.StatusAction.COMPLETE)
                )
        );
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancel(@PathVariable UUID id) {
        return ResponseEntity.ok(
                statusHandler.execute(
                        new ChangeAppointmentStatusCommand(id, ChangeAppointmentStatusCommand.StatusAction.CANCEL)
                )
        );
    }

    @GetMapping("/psychologist/{psychologistId}")
    public ResponseEntity<List<Appointment>> getByPsychologist(@PathVariable Long psychologistId) {
        return ResponseEntity.ok(
                getByPsychologistHandler.execute(
                        new GetAppointmentsByPsychologistIdQuery(psychologistId)
                )
        );
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Appointment>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(
                getByEmployeeHandler.execute(
                        new GetAppointmentsByEmployeeIdQuery(employeeId)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteHandler.execute(new DeleteAppointmentCommand(id));
        return ResponseEntity.noContent().build();
    }
}
