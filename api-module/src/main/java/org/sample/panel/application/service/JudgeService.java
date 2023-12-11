package org.sample.panel.application.service;

import lombok.RequiredArgsConstructor;
import org.sample.common.enums.ErrorMessage;
import org.sample.common.exeption.CustomApiException;
import org.sample.common.service.port.ClockHolder;
import org.sample.panel.domain.dto.request.EndJudgeDto;
import org.sample.panel.domain.dto.request.StartJudgeDto;
import org.sample.panel.domain.model.JudgePanel;
import org.sample.panel.application.port.in.JudgeUseCase;
import org.sample.panel.application.port.out.JudgePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JudgeService implements JudgeUseCase {

    private final JudgePort judgePort;
    private final ClockHolder clockHolder;

    @Override
    @Transactional
    public boolean startJudge(StartJudgeDto startJudgeDto) {
        JudgePanel judgePanel = judgePort.findJudgePanelById(startJudgeDto.getScanIndex())
                .orElseThrow(() -> new CustomApiException(ErrorMessage.NOT_FOUND_PANEL));

        judgePanel.startJudge(startJudgeDto.getOperator(), clockHolder);

        judgePort.saveJudgePaenl(judgePanel);
        return true;
    }

    @Override
    @Transactional
    public boolean endJudge(EndJudgeDto endJudgeDto) {
        JudgePanel judgePanel = judgePort.findJudgePanelById(endJudgeDto.getScanIndex())
                .orElseThrow(() -> new CustomApiException(ErrorMessage.NOT_FOUND_PANEL));

        judgePanel.endJudge(endJudgeDto.getOperator(), clockHolder);

        judgePort.saveJudgePaenl(judgePanel);
        return false;
    }
}
