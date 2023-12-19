package org.sample.panel.adapter.out.persistence;

import lombok.RequiredArgsConstructor;

import org.sample.panel.application.port.out.PanelPort;
import org.sample.panel.domain.model.PanelState;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JudgeRepository implements PanelPort {


    @Override
    public boolean printState(PanelState panel) {
        System.out.println(panel);
        return false;
    }
}
