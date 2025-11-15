package com.mindora.platform.reports.domain.model.commands;

import com.mindora.platform.reports.domain.model.valueobjects.ReportType;

import java.time.LocalDate;

public record CreateReportCommand(
        Long employeeId,
        String title,
        String content,
        String summary,
        ReportType type,
        Integer completedTasks,
        Integer pendingTasks,
        Integer blockers,
        LocalDate reportDate
) {
}
