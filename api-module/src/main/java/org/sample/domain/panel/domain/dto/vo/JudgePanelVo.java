package org.sample.domain.panel.domain.dto.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sample.domain.panel.domain.model.JudgePanel;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class JudgePanelVo {
    private final long scanIndex;
    private final String judgeCode;
    private final String department;
    private final String operator;
    private final LocalDateTime startTime;
    private final LocalDateTime judgeTime;

    public JudgePanel toModel() {
        return JudgePanel.builder()
                .scanIndex(scanIndex)
                .judgeCode(judgeCode)
                .department(department)
                .operator(operator)
                .startTime(startTime)
                .judgeTime(judgeTime)
                .build();
    }

}
