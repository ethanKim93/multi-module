package org.sample.panel.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sample.common.service.port.ClockHolder;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class JudgePanel {
    private long scanIndex;
    private String judgeCode;
    private String department;
    private String operator;
    private LocalDateTime startTime;
    private LocalDateTime judgeTime;


//    @Builder
//    public JudgePanel(long scanIndex, String judgeCode) {
//        this.scanIndex = scanIndex;
//        this.judgeCode = judgeCode;
//    }

    @Builder
    public JudgePanel(long scanIndex, String judgeCode, String department, String operator, LocalDateTime startTime, LocalDateTime judgeTime) {
        this.scanIndex = scanIndex;
        this.judgeCode = judgeCode;
        this.department = department;
        this.operator = operator;
        this.startTime = startTime;
        this.judgeTime = judgeTime;
    }

    public String updateJudgeCode(String judgeCode, String operator, String department) {
        if (!this.department.equals(department)) {
            return "불일치";
        }

        this.judgeCode = judgeCode;
        this.operator = operator;
        return "OK";
    }

    public void startJudgeOld(String operator) {
        startTime = LocalDateTime.now();
        this.operator = operator;
    }


    public void startJudge(String operator, ClockHolder clockHolder) {
        startTime = clockHolder.nowTime();
        this.operator = operator;
    }

    public void endJudgeOld(String operator) {
        startTime = LocalDateTime.now();
        this.operator = operator;
    }

    public void endJudge(String operator, ClockHolder clockHolder) {
        judgeTime = clockHolder.nowTime();
        this.operator = operator;
    }


}
