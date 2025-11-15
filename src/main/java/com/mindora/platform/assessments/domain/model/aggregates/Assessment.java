package com.mindora.platform.assessments.domain.model.aggregates;

import com.mindora.platform.assessments.domain.model.valueobjects.*;
import com.mindora.platform.shared.domain.model.aggregates.BaseAuditableAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "assessments")
@NoArgsConstructor
public class Assessment extends BaseAuditableAggregateRoot<Assessment> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "employee_id"))
    private EmployeeId employeeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "assessment_type")
    private AssessmentType assessmentType;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "score"))
    private AssessmentScore score;

    @Enumerated(EnumType.STRING)
    @Column(name = "emotional_state")
    private EmotionalState emotionalState;

    @Column(columnDefinition = "TEXT")
    private String observations;

    @Column(columnDefinition = "TEXT")
    private String recommendations;

    public Assessment(EmployeeId employeeId,
                      AssessmentType assessmentType,
                      AssessmentScore score,
                      EmotionalState emotionalState,
                      String observations,
                      String recommendations) {

        this.employeeId = employeeId;
        this.assessmentType = assessmentType;
        this.score = score;
        this.emotionalState = emotionalState;
        this.observations = observations;
        this.recommendations = recommendations;
    }

    public void updateAssessment(AssessmentScore score,
                                 EmotionalState emotionalState,
                                 String observations,
                                 String recommendations) {
        this.score = score;
        this.emotionalState = emotionalState;
        this.observations = observations;
        this.recommendations = recommendations;
    }
}

