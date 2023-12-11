package org.sample.panel.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        judgePanel.startJudge("홍길동", nowTime);
        //then
        assertThat(judgePanel.getOperator()).isEqualTo("홍길동");
        assertThat(judgePanel.getStartTime()).isEqualTo(nowTime);
    }
}
