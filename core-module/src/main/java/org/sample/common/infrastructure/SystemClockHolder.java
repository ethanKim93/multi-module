package org.sample.common.infrastructure;

import org.sample.common.service.port.ClockHolder;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class SystemClockHolder implements ClockHolder {

    @Override
    public long millis() {
        return Clock.systemUTC().millis();
    }

    @Override
    public LocalDateTime nowTime() {
        return LocalDateTime.now();
    }
}