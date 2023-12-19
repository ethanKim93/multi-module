package org.sample.panel.adapter.in.schedular;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.sample.panel.application.port.in.PanelUseCase;

@Slf4j
@Component
@RequiredArgsConstructor
public class PanelScheduler {
    private final PanelUseCase panelUseCase;
    static long n = 0;

    @Scheduled(fixedRate = 1000)
    public void samplePathVariable() throws InterruptedException {
        panelUseCase.checkPanelState();
    }

}
