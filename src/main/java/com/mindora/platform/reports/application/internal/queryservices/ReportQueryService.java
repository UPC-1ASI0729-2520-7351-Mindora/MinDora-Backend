package com.mindora.platform.reports.application.internal.queryservices;

import com.mindora.platform.reports.interfaces.rest.resources.ReportResource;

import java.util.List;

public interface ReportQueryService {

    List<ReportResource> getAllReports();

    ReportResource getReportById(Long reportId);

    List<ReportResource> getReportsByEmployeeId(Long employeeId);
}
