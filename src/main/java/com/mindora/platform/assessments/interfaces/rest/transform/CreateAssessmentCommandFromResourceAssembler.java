package com.mindora.platform.assessments.interfaces.rest.transform;

import com.mindora.platform.assessments.domain.model.commands.CreateAssessmentCommand;
import com.mindora.platform.assessments.domain.model.valueobjects.*;
import com.mindora.platform.assessments.interfaces.rest.resources.CreateAssessmentResource;

public class CreateAssessmentCommandFromResourceAssembler {

    public static CreateAssessmentCommand toCommand(CreateAssessmentResource resource) {
        return new CreateAssessmentCommand(
                new EmployeeId(resource.employeeId()),
                resource.assessmentType(),
                new AssessmentScore(resource.score()),
                resource.emotionalState(),
                resource.observations(),
                resource.recommendations()
        );
    }
}
