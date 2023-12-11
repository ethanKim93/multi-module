package org.sample.common.service.port;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ClockHolder {
    long millis();

    LocalDateTime nowTime();
}
