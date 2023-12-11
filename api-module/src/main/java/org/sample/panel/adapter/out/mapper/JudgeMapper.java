package org.sample.panel.adapter.out.mapper;

import org.sample.panel.domain.dto.vo.JudgePanelVo;
import org.sample.panel.domain.dto.vo.PanelVo;
import org.sample.panel.domain.model.JudgePanel;
import org.sample.panel.domain.model.Panel;
import org.sample.panel.application.port.out.JudgePort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JudgeMapper {


    public Optional<PanelVo> findPanelById(long scanIndex) {
        return Optional.empty();
    }

    public Optional<JudgePanelVo> findJudgePanelById(long scanIndex) {
        return Optional.empty();
    }

    public boolean saveJudgePaenl(JudgePanelVo panel) {
        return false;
    }

    public boolean savePaenl(PanelVo panel) {
        return false;
    }
}
