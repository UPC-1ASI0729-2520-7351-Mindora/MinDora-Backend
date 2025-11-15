package com.mindora.platform.assessments.infrastructure.persistence.jpa.repositories;

import com.mindora.platform.assessments.domain.model.aggregates.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findByEmployeeIdValue(Long employeeId);
}
