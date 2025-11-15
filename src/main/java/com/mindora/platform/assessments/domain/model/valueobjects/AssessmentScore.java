package com.mindora.platform.assessments.domain.model.valueobjects;

public record AssessmentScore(int value) {

    private static final int MIN = 0;
    private static final int MAX = 100;

    public AssessmentScore {
        if (value < MIN || value > MAX)
            throw new IllegalArgumentException(
                    "AssessmentScore must be between 0 and 100."
            );
    }
}
