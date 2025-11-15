package com.mindora.platform.reports.domain.model.commands;

public record UpdateReportContentCommand(
        Long reportId,
        String content,
        String summary
) {
}
