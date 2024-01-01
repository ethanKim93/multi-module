package org.sample.domain.panel.application.port.out;

import org.sample.domain.panel.domain.model.JudgePanel;
import org.sample.domain.panel.domain.model.Panel;

import java.util.Optional;

public interface JudgePort {
    Optional<Panel> findPanelById(long scanIndex);

    Optional<JudgePanel> findJudgePanelById(long scanIndex);

    boolean saveJudgePaenl(JudgePanel panel);

    boolean savePaenl(Panel panel);

}
