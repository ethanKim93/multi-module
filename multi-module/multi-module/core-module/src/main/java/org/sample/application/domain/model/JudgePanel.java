package org.sample.application.domain.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class JudgePanel {

    private long scanIndex;
    private String judgeCode;
    private String department;
    private String operator;
    private LocalDateTime startTime;

    @Builder
    public JudgePanel(long scanIndex, String judgeCode) {
        this.scanIndex = scanIndex;
        this.judgeCode = judgeCode;
    }

    public String updateJudgeCode(String judgeCode, String operator, String department) {
        if (!this.department.equals(department)) {
            return "불일치";
        }

        this.judgeCode = judgeCode;
        this.operator = operator;
        return "OK";
    }

    public void startJudge(String operator) {
        startTime = LocalDateTime.now();
        this.operator = operator;
    }

    
}
