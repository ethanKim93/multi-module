package org.sample.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.sample.application.domain.model.JudgePanel;
import org.sample.application.domain.model.Panel;
import org.sample.application.port.in.JudgeUseCase;
import org.sample.application.port.out.JudgePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JudgeService implements JudgeUseCase {

    private final JudgePort judgePort;

    @Override
    public boolean startJudge(long scanIndex) {
//        Panel targetPanel = judgePort.findPanelById(scanIndex)
//                .orElseThrow(() -> new RuntimeException());

        JudgePanel judgePanel = judgePort.findJudgePanelById(scanIndex)
                .orElseThrow(() -> new RuntimeException());

        judgePanel.startJudge("김민현");

        judgePort.saveJudgePaenl(judgePanel);
        return false;
    }

    @Override
    public boolean endJudge(Panel panel) {
        return false;
    }
}
