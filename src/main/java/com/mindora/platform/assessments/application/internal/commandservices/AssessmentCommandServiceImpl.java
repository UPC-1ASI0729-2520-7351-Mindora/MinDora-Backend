package com.mindora.platform.assessments.application.internal.commandservices;

import com.mindora.platform.assessments.domain.model.aggregates.Assessment;
import com.mindora.platform.assessments.domain.model.commands.CreateAssessmentCommand;
import com.mindora.platform.assessments.domain.model.commands.UpdateAssessmentCommand;
import com.mindora.platform.assessments.domain.services.AssessmentCommandService;
import com.mindora.platform.assessments.infrastructure.persistence.jpa.repositories.AssessmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssessmentCommandServiceImpl implements AssessmentCommandService {

    private final AssessmentRepository repository;

    public AssessmentCommandServiceImpl(AssessmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long handle(CreateAssessmentCommand command) {
        var assessment = new Assessment(
                command.employeeId(),
                command.assessmentType(),
                command.score(),
                command.emotionalState(),
                command.observations(),
                command.recommendations()
        );

        var saved = repository.save(assessment);
        return saved.getId();
    }

    @Override
    public Optional<Assessment> handle(UpdateAssessmentCommand command) {
        var found = repository.findById(command.assessmentId());
        if (found.isEmpty()) return Optional.empty();

        var assessment = found.get();

        assessment.updateAssessment(
                command.score(),
                command.emotionalState(),
                command.observations(),
                command.recommendations()
        );

        return Optional.of(repository.save(assessment));
    }
}
