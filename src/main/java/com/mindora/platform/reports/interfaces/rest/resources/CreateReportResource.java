package com.mindora.platform.reports.interfaces.rest.resources;

import java.time.LocalDate;


public record CreateReportResource(
        Long employeeId,
        String title,
        String content,
        String summary,
        String type,
        Integer completedTasks,
        Integer pendingTasks,
        Integer blockers,
        LocalDate reportDate
) {
}
