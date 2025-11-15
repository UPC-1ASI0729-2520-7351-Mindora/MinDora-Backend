package com.mindora.platform.reports.interfaces.rest.transform;

import com.mindora.platform.reports.domain.model.aggregates.Report;
import com.mindora.platform.reports.domain.model.valueobjects.ProgressMetrics;
import com.mindora.platform.reports.interfaces.rest.resources.ReportResource;
import org.springframework.stereotype.Component;

@Component
public class ReportResourceAssembler {

    public ReportResource toResource(Report report) {
        if (report == null) return null;

        Integer completedTasks = null;
        Integer pendingTasks   = null;
        Integer blockers       = null;

        ProgressMetrics progress = report.getProgressMetrics();
        if (progress != null) {
            completedTasks = progress.getCompletedTasks();
            pendingTasks   = progress.getPendingTasks();
            blockers       = progress.getBlockers();
        }

        return new ReportResource(
                report.getId(),
                report.getEmployeeId().getValue(),
                report.getTitle(),
                report.getContent(),
                report.getSummary(),
                report.getType().name(),
                completedTasks,
                pendingTasks,
                blockers,
                report.getReportDate(),
                report.getCreatedAt(),
                report.getUpdatedAt()
        );
    }
}
