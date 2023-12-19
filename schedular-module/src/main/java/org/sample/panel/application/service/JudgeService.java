package org.sample.panel.application.service;

import lombok.RequiredArgsConstructor;
import org.sample.common.service.port.ClockHolder;
import org.sample.panel.application.port.out.PanelPort;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.sample.panel.application.port.in.PanelUseCase;
import org.sample.panel.domain.model.PanelState;

@Service
@Configuration
@RequiredArgsConstructor
public class JudgeService implements PanelUseCase {

    private final ClockHolder clockHolder;
    private final PanelPort panelPort;

    @Override
    public boolean checkPanelState() {
        PanelState panelState = PanelState.builder()
                .scanIndex(1)
                .state("OK")
                .updateTime(clockHolder.nowTime())
                .build();

        panelState.updateState("NG", clockHolder);

        panelPort.printState(panelState);

        return false;
    }
}
