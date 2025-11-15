package com.mindora.platform.reports.application.internal.commandservices;

import com.mindora.platform.reports.domain.model.aggregates.Report;
import com.mindora.platform.reports.domain.model.commands.CreateReportCommand;
import com.mindora.platform.reports.domain.model.valueobjects.EmployeeId;
import com.mindora.platform.reports.domain.model.valueobjects.ProgressMetrics;
import com.mindora.platform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import com.mindora.platform.reports.interfaces.rest.resources.ReportResource;
import com.mindora.platform.reports.interfaces.rest.transform.ReportResourceAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportCommandServiceImpl implements ReportCommandService {

    private final ReportRepository reportRepository;
    private final ReportResourceAssembler reportResourceAssembler;

    @Override
    public ReportResource createReport(CreateReportCommand command) {

        EmployeeId employeeId = new EmployeeId(command.employeeId());
        ProgressMetrics progressMetrics = new ProgressMetrics(
                command.completedTasks(),
                command.pendingTasks(),
                command.blockers()
        );

        Report report = Report.create(
                employeeId,
                command.title(),
                command.content(),
                command.summary(),
                command.type(),
                progressMetrics,
                command.reportDate()
        );

        reportRepository.save(report);

        return reportResourceAssembler.toResource(report);
    }
}
