package com.mindora.platform.reports.domain.services;

import com.mindora.platform.reports.domain.model.aggregates.Report;
import com.mindora.platform.reports.domain.model.commands.CreateReportCommand;
import com.mindora.platform.reports.domain.model.commands.UpdateReportContentCommand;
import com.mindora.platform.reports.domain.model.commands.UpdateReportProgressCommand;

public interface ReportCommandService {

    Report createReport(CreateReportCommand command);

    Report updateReportContent(UpdateReportContentCommand command);

    Report updateReportProgress(UpdateReportProgressCommand command);
}
