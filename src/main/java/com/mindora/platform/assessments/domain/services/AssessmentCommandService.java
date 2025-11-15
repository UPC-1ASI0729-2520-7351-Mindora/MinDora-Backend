package com.mindora.platform.assessments.domain.services;

import com.mindora.platform.assessments.domain.model.aggregates.Assessment;
import com.mindora.platform.assessments.domain.model.commands.*;
import java.util.Optional;

public interface AssessmentCommandService {
    Long handle(CreateAssessmentCommand command);
    Optional<Assessment> handle(UpdateAssessmentCommand command);
}
