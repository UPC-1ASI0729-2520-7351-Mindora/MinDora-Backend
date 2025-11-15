package com.mindora.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProgressMetrics {

    private Integer completedTasks;
    private Integer pendingTasks;
    private Integer blockers;

    public ProgressMetrics(Integer completedTasks,
                           Integer pendingTasks,
                           Integer blockers) {
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.blockers = blockers;
    }
}
