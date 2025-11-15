package com.mindora.platform.reports.domain.exceptions;

public class ReportNotFoundException extends RuntimeException {

    public ReportNotFoundException(Long reportId) {
        super("Report with id %d was not found".formatted(reportId));
    }
}
