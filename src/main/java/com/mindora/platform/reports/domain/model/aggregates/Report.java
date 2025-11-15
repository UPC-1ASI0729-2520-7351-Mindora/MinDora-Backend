package com.mindora.platform.reports.domain.model.aggregates;

import com.mindora.platform.reports.domain.model.valueobjects.EmployeeId;
import com.mindora.platform.reports.domain.model.valueobjects.ProgressMetrics;
import com.mindora.platform.reports.domain.model.valueobjects.ReportType;
import com.mindora.platform.shared.domain.model.aggregates.BaseAuditableAggregateRoot;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "reports")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BaseAuditableAggregateRoot<Report> {

    @Embedded
    private EmployeeId employeeId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 4000)
    private String content;

    @Column(nullable = false, length = 1000)
    private String summary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportType type;

    @Embedded
    private ProgressMetrics progressMetrics;

    @Column(nullable = false)
    private LocalDate reportDate;

    //Factory method

    private Report(EmployeeId employeeId,
                   String title,
                   String content,
                   String summary,
                   ReportType type,
                   ProgressMetrics progressMetrics,
                   LocalDate reportDate) {

        if (employeeId == null) throw new IllegalArgumentException("employeeId is required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title is required");
        if (content == null || content.isBlank()) throw new IllegalArgumentException("content is required");
        if (summary == null || summary.isBlank()) throw new IllegalArgumentException("summary is required");
        if (type == null) throw new IllegalArgumentException("type is required");
        if (reportDate == null) reportDate = LocalDate.now();

        this.employeeId = employeeId;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.type = type;
        this.progressMetrics = progressMetrics;
        this.reportDate = reportDate;
    }

    public static Report create(EmployeeId employeeId,
                                String title,
                                String content,
                                String summary,
                                ReportType type,
                                ProgressMetrics progressMetrics,
                                LocalDate reportDate) {
        return new Report(employeeId, title, content, summary, type, progressMetrics, reportDate);
    }

    public void updateContent(String content, String summary) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content is required");
        }
        if (summary == null || summary.isBlank()) {
            throw new IllegalArgumentException("summary is required");
        }
        this.content = content;
        this.summary = summary;
    }

    public void updateProgressMetrics(ProgressMetrics progressMetrics) {
        this.progressMetrics = progressMetrics;
    }
}
