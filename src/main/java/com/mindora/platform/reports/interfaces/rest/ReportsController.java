package com.mindora.platform.reports.interfaces.rest;

import com.mindora.platform.reports.application.internal.commandservices.ReportCommandService;
import com.mindora.platform.reports.application.internal.queryservices.ReportQueryService;
import com.mindora.platform.reports.domain.model.commands.CreateReportCommand;
import com.mindora.platform.reports.domain.model.valueobjects.ReportType;
import com.mindora.platform.reports.interfaces.rest.resources.CreateReportResource;
import com.mindora.platform.reports.interfaces.rest.resources.ReportResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
@Tag(name = "Reports-Controller", description = "Available Report Endpoints")
public class ReportsController {

    private final ReportCommandService reportCommandService;
    private final ReportQueryService reportQueryService;

    @GetMapping
    public List<ReportResource> getAllReports() {
        return reportQueryService.getAllReports();
    }

    @GetMapping("/{reportId}")
    public ReportResource getReportById(@PathVariable Long reportId) {
        return reportQueryService.getReportById(reportId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ReportResource> getReportsByEmployeeId(@PathVariable Long employeeId) {
        return reportQueryService.getReportsByEmployeeId(employeeId);
    }

    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody CreateReportResource resource) {

        CreateReportCommand command = new CreateReportCommand(
                resource.employeeId(),
                resource.title(),
                resource.content(),
                resource.summary(),
                ReportType.valueOf(resource.type()),
                resource.completedTasks(),
                resource.pendingTasks(),
                resource.blockers(),
                resource.reportDate()
        );

        ReportResource created = reportCommandService.createReport(command);

        return ResponseEntity
                .created(URI.create("/api/v1/reports/" + created.id()))
                .body(created);
    }
}
