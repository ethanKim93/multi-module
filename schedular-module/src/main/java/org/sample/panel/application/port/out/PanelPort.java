package org.sample.panel.application.port.out;

import org.sample.panel.domain.model.PanelState;

public interface PanelPort {

    boolean printState(PanelState panel);


}
