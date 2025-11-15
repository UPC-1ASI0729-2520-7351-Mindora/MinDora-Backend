package com.mindora.platform.assessments.interfaces.rest;

import com.mindora.platform.assessments.domain.model.queries.*;
import com.mindora.platform.assessments.domain.services.*;
import com.mindora.platform.assessments.interfaces.rest.resources.*;
import com.mindora.platform.assessments.interfaces.rest.transform.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/assessments")
public class AssessmentsController {

    private final AssessmentCommandService commandService;
    private final AssessmentQueryService queryService;

    public AssessmentsController(AssessmentCommandService commandService,
                                 AssessmentQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<AssessmentResource> createAssessment(@RequestBody CreateAssessmentResource resource) {
        var command = CreateAssessmentCommandFromResourceAssembler.toCommand(resource);
        var id = commandService.handle(command);

        var assessment = queryService.handle(new GetAssessmentByIdQuery(id)).orElseThrow();
        var res = AssessmentResourceFromEntityAssembler.toResource(assessment);

        return ResponseEntity.created(URI.create("/api/v1/assessments/" + id)).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssessmentResource> updateAssessment(@PathVariable Long id,
                                                               @RequestBody UpdateAssessmentResource resource) {
        var updated = commandService.handle(
                UpdateAssessmentCommandFromResourceAssembler.toCommand(id, resource)
        ).orElseThrow();

        return ResponseEntity.ok(AssessmentResourceFromEntityAssembler.toResource(updated));
    }

    @GetMapping
    public ResponseEntity<List<AssessmentResource>> getAllAssessments() {
        var list = queryService.handle(new GetAllAssessmentsQuery());
        var resources = list.stream().map(AssessmentResourceFromEntityAssembler::toResource).toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentResource> getById(@PathVariable Long id) {
        var assessment = queryService.handle(new GetAssessmentByIdQuery(id));
        return assessment
                .map(a -> ResponseEntity.ok(AssessmentResourceFromEntityAssembler.toResource(a)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AssessmentResource>> getByEmployee(@PathVariable Long employeeId) {
        var list = queryService.handle(new GetAllAssessmentsByEmployeeIdQuery(employeeId));
        var resources = list.stream().map(AssessmentResourceFromEntityAssembler::toResource).toList();
        return ResponseEntity.ok(resources);
    }
}
