package org.sample.panel.domain.model;

import lombok.*;
import org.sample.common.service.port.ClockHolder;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@ToString
public class PanelState {
    private long scanIndex;
    private String state;
    private LocalDateTime updateTime;


    @Builder
    public PanelState(long scanIndex, String state, LocalDateTime updateTime) {
        this.scanIndex = scanIndex;
        this.state = state;
        this.updateTime = updateTime;
    }

    public void updateState(String state, ClockHolder clockHolder) {
        this.state = state;
        this.updateTime = clockHolder.nowTime();
    }
}
