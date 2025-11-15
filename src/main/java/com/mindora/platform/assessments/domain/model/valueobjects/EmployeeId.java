package com.mindora.platform.assessments.domain.model.valueobjects;

public record EmployeeId(Long value) {
    public EmployeeId {
        if (value == null || value <= 0)
            throw new IllegalArgumentException("EmployeeId must be positive.");
    }
}
