package org.sample.adapter.out.persistence;

import org.sample.application.domain.model.JudgePanel;
import org.sample.application.domain.model.Panel;
import org.sample.application.port.out.JudgePort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JudgeMapper implements JudgePort {


    @Override
    public Optional<Panel> findPanelById(long scanIndex) {
        return Optional.empty();
    }

    @Override
    public Optional<JudgePanel> findJudgePanelById(long scanIndex) {
        return Optional.empty();
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
