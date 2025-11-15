package com.mindora.platform.assessments.interfaces.rest.resources;

import com.mindora.platform.assessments.domain.model.valueobjects.*;
import java.time.LocalDateTime;

public record AssessmentResource(
        Long id,
        Long employeeId,
        AssessmentType assessmentType,
        int score,
        EmotionalState emotionalState,
        String observations,
        String recommendations,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
