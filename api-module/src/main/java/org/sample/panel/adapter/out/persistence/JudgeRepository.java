package org.sample.panel.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sample.panel.adapter.out.mapper.JudgeMapper;
import org.sample.panel.application.port.out.JudgePort;
import org.sample.panel.domain.dto.vo.JudgePanelVo;
import org.sample.panel.domain.dto.vo.PanelVo;
import org.sample.panel.domain.model.JudgePanel;
import org.sample.panel.domain.model.Panel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JudgeRepository implements JudgePort {

    private final JudgeMapper judgeMapper;

    @Override
    public Optional<Panel> findPanelById(long scanIndex) {
        return judgeMapper.findPanelById(scanIndex).map(PanelVo::toModel);
    }

    @Override
    public Optional<JudgePanel> findJudgePanelById(long scanIndex) {
        return judgeMapper.findJudgePanelById(scanIndex).map(JudgePanelVo::toModel);
    }

    @Override
    public boolean saveJudgePaenl(JudgePanel panel) {
        return false;
    }

    @Override
    public boolean savePaenl(Panel panel) {
        return false;
    }
}
