package com.mindora.platform.reports.application.internal.queryservices;

import com.mindora.platform.reports.domain.model.valueobjects.EmployeeId;
import com.mindora.platform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import com.mindora.platform.reports.interfaces.rest.resources.ReportResource;
import com.mindora.platform.reports.interfaces.rest.transform.ReportResourceAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportQueryServiceImpl implements ReportQueryService {

    private final ReportRepository reportRepository;
    private final ReportResourceAssembler reportResourceAssembler;

    @Override
    public List<ReportResource> getAllReports() {
        return reportRepository.findAll()
                .stream()
                .map(reportResourceAssembler::toResource)
                .toList();
    }

    @Override
    public ReportResource getReportById(Long reportId) {
        return reportRepository.findById(reportId)
                .map(reportResourceAssembler::toResource)
                .orElse(null);
    }

    @Override
    public List<ReportResource> getReportsByEmployeeId(Long employeeId) {
        EmployeeId employeeIdVo = new EmployeeId(employeeId);

        return reportRepository.findByEmployeeId(employeeIdVo)
                .stream()
                .map(reportResourceAssembler::toResource)
                .toList();
    }
}
