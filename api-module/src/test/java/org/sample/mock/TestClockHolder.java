package org.sample.mock;

import lombok.RequiredArgsConstructor;
import org.sample.common.service.port.ClockHolder;

import java.time.LocalDateTime;

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

    public void initNowTime() {
        localDateTime = LocalDateTime.now();
    }
}