package com.mindora.platform.assessments.domain.model.commands;

import com.mindora.platform.assessments.domain.model.valueobjects.*;

public record UpdateAssessmentCommand(
        Long assessmentId,
        AssessmentScore score,
        EmotionalState emotionalState,
        String observations,
        String recommendations
) {}
