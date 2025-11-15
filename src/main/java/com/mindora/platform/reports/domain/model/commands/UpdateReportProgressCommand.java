package com.mindora.platform.reports.domain.model.commands;

public record UpdateReportProgressCommand(
        Long reportId,
        Integer progressScore,
        Integer motivationScore,
        Integer stressLevel
) {
}
