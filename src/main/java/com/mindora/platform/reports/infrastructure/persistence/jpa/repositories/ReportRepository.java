package com.mindora.platform.reports.infrastructure.persistence.jpa.repositories;

import com.mindora.platform.reports.domain.model.aggregates.Report;
import com.mindora.platform.reports.domain.model.valueobjects.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {


    List<Report> findByEmployeeId(EmployeeId employeeId);
}
