package com.mindora.platform.assessments.domain.exceptions;

public class AssessmentNotFoundException extends RuntimeException {

    public AssessmentNotFoundException(Long id) {
        super("Assessment with id %s was not found.".formatted(id));
    }
}
