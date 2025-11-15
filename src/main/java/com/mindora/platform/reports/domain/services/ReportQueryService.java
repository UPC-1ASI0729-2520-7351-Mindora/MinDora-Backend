package com.mindora.platform.reports.domain.services;

import com.mindora.platform.reports.domain.model.aggregates.Report;

import java.util.List;
import java.util.Optional;

public interface ReportQueryService {

    Optional<Report> getReportById(Long reportId);

    List<Report> getReportsByEmployeeId(Long employeeId);
}
