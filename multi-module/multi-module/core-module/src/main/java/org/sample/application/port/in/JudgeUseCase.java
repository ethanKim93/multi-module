package org.sample.application.port.in;

import org.sample.application.domain.model.Panel;

public interface JudgeUseCase {

    boolean startJudge(long scanIndex);

    boolean endJudge(Panel panel);

}
