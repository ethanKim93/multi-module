package org.sample.panel.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sample.common.service.port.ClockHolder;
import org.sample.mock.TestClockHolder;
import org.sample.panel.domain.model.JudgePanel;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class JudgePanelTest {

    @Test
    @DisplayName("판정 시작")
    public void startJudgeTest() {
        //given
        JudgePanel judgePanel = JudgePanel.builder()
                .scanIndex(1).judgeCode("NG").build();
        //when
        LocalDateTime nowTime = LocalDateTime.now();
        ClockHolder clockHolder = new TestClockHolder(nowTime);
        judgePanel.startJudge("홍길동", clockHolder);
        //then
        assertThat(judgePanel.getOperator()).isEqualTo("홍길동");
        assertThat(judgePanel.getStartTime()).isEqualTo(nowTime);
    }
}
