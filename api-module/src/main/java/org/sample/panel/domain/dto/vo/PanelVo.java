package org.sample.panel.domain.dto.vo;

import lombok.RequiredArgsConstructor;
import org.sample.panel.domain.model.JudgePanel;
import org.sample.panel.domain.model.Panel;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PanelVo {

    private final String panelId;
    private final long scanIndex;
    private final String equipType;
    private final String operator;
    private final LocalDateTime updateDateTime;
    private final LocalDateTime createDateTime;

    public Panel toModel() {
        return Panel.builder()
                .panelId(panelId)
                .scanIndex(scanIndex)
                .equipType(equipType)
                .operator(operator)
                .updateDateTime(updateDateTime)
                .createDateTime(createDateTime)
                .build();
    }
}
