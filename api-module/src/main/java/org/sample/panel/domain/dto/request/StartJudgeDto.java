package org.sample.panel.domain.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StartJudgeDto {
    private long scanIndex;
    private String operator;

    @Builder
    public StartJudgeDto(long scanIndex, String operator) {
        this.scanIndex = scanIndex;
        this.operator = operator;
    }
}
