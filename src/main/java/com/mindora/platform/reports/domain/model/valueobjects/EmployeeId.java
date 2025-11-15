package com.mindora.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmployeeId {

    @Column(name = "employee_id", nullable = false)
    private Long value;

    public EmployeeId(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("EmployeeId must be a positive number");
        }
        this.value = value;
    }
}
