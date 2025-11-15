package com.mindora.platform.assessments.interfaces.rest.transform;

import com.mindora.platform.assessments.domain.model.aggregates.Assessment;
import com.mindora.platform.assessments.interfaces.rest.resources.AssessmentResource;

public class AssessmentResourceFromEntityAssembler {

    public static AssessmentResource toResource(Assessment assessment) {
        return new AssessmentResource(
                assessment.getId(),
                assessment.getEmployeeId().value(),
                assessment.getAssessmentType(),
                assessment.getScore().value(),
                assessment.getEmotionalState(),
                assessment.getObservations(),
                assessment.getRecommendations(),
                assessment.getCreatedAt(),
                assessment.getUpdatedAt()
        );
    }
}
