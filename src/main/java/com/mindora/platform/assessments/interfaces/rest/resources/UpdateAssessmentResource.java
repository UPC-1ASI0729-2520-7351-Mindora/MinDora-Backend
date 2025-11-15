package com.mindora.platform.assessments.interfaces.rest.resources;

import com.mindora.platform.assessments.domain.model.valueobjects.*;

public record UpdateAssessmentResource(
        int score,
        EmotionalState emotionalState,
        String observations,
        String recommendations
) {}
