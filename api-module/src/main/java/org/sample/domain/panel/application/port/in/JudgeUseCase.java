package org.sample.domain.panel.application.port.in;

import org.sample.domain.panel.domain.dto.request.EndJudgeDto;
import org.sample.domain.panel.domain.dto.request.StartJudgeDto;

public interface JudgeUseCase {

    boolean startJudge(StartJudgeDto startJudgeDto);

    boolean endJudge(EndJudgeDto endJudgeDto);
}
