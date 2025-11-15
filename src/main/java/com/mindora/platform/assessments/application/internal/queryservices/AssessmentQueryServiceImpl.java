package com.mindora.platform.assessments.application.internal.queryservices;

import com.mindora.platform.assessments.domain.model.queries.*;
import com.mindora.platform.assessments.domain.services.AssessmentQueryService;
import com.mindora.platform.assessments.infrastructure.persistence.jpa.repositories.AssessmentRepository;
import com.mindora.platform.assessments.domain.model.aggregates.Assessment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentQueryServiceImpl implements AssessmentQueryService {

    private final AssessmentRepository repository;

    public AssessmentQueryServiceImpl(AssessmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Assessment> handle(GetAssessmentByIdQuery query) {
        return repository.findById(query.assessmentId());
    }

    @Override
    public List<Assessment> handle(GetAllAssessmentsQuery query) {
        return repository.findAll();
    }

    @Override
    public List<Assessment> handle(GetAllAssessmentsByEmployeeIdQuery query) {
        return repository.findByEmployeeIdValue(query.employeeId());
    }
}
