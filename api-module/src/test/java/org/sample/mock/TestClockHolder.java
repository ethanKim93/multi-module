package org.sample.mock;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sample.common.service.port.ClockHolder;

import java.time.LocalDateTime;

@NoArgsConstructor
public class TestClockHolder implements ClockHolder {

    private long millis;
    private LocalDateTime localDateTime;

    @Override
    public long millis() {
        return millis;
    }

    @Override
    public LocalDateTime nowTime() {
        return localDateTime;
    }

    public TestClockHolder(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void initNowTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void initMills(long millis) {
        this.millis = millis;
    }
}