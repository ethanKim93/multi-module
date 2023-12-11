package org.sample.panel.application.port.out;

import org.sample.panel.domain.dto.vo.PanelVo;
import org.sample.panel.domain.model.JudgePanel;
import org.sample.panel.domain.model.Panel;

import java.util.Optional;

public interface JudgePort {
    Optional<Panel> findPanelById(long scanIndex);

    Optional<JudgePanel> findJudgePanelById(long scanIndex);

    boolean saveJudgePaenl(JudgePanel panel);

    boolean savePaenl(Panel panel);

}
