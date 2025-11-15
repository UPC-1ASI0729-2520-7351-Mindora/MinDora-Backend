package com.mindora.platform.assessments.domain.services;

import com.mindora.platform.assessments.domain.model.aggregates.Assessment;
import com.mindora.platform.assessments.domain.model.queries.*;
import java.util.List;
import java.util.Optional;

public interface AssessmentQueryService {
    Optional<Assessment> handle(GetAssessmentByIdQuery query);
    List<Assessment> handle(GetAllAssessmentsQuery query);
    List<Assessment> handle(GetAllAssessmentsByEmployeeIdQuery query);
}
