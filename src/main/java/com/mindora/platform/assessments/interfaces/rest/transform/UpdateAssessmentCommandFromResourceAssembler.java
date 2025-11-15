package com.mindora.platform.assessments.interfaces.rest.transform;

import com.mindora.platform.assessments.domain.model.commands.UpdateAssessmentCommand;
import com.mindora.platform.assessments.domain.model.valueobjects.*;
import com.mindora.platform.assessments.interfaces.rest.resources.UpdateAssessmentResource;

public class UpdateAssessmentCommandFromResourceAssembler {

    public static UpdateAssessmentCommand toCommand(Long id, UpdateAssessmentResource resource) {
        return new UpdateAssessmentCommand(
                id,
                new AssessmentScore(resource.score()),
                resource.emotionalState(),
                resource.observations(),
                resource.recommendations()
        );
    }
}
