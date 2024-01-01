package org.sample.domain.panel.application.port.in;

import java.util.List;
import java.util.Queue;

public interface JobUseCase {

    void assignNextJob(Queue<String> jobs);
}
