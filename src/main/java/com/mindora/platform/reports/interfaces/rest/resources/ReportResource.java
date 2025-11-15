package com.mindora.platform.reports.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record ReportResource(
        Long id,
        Long employeeId,
        String title,
        String content,
        String summary,
        String type,
        Integer completedTasks,
        Integer pendingTasks,
        Integer blockers,
        LocalDate reportDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
