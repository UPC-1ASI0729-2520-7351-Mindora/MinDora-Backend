package com.mindora.platform.reports.application.internal.commandservices;

import com.mindora.platform.reports.domain.model.commands.CreateReportCommand;
import com.mindora.platform.reports.interfaces.rest.resources.ReportResource;

public interface ReportCommandService {

    ReportResource createReport(CreateReportCommand command);
}
