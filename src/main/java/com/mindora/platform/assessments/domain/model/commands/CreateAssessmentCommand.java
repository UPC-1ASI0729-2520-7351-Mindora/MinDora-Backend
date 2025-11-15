package com.mindora.platform.assessments.domain.model.commands;

import com.mindora.platform.assessments.domain.model.valueobjects.*;

public record CreateAssessmentCommand(
        EmployeeId employeeId,
        AssessmentType assessmentType,
        AssessmentScore score,
        EmotionalState emotionalState,
        String observations,
        String recommendations
) {}
