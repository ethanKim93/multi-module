package org.sample.domain.panel.adapter.out.mapper;

import org.sample.domain.panel.domain.dto.vo.JudgePanelVo;
import org.sample.domain.panel.domain.dto.vo.PanelVo;
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
