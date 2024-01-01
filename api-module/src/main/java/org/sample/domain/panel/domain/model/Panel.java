package org.sample.domain.panel.domain.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
public class Panel {

    private String panelId;
    private long scanIndex;
    private String equipType;

    private String operator;


    private LocalDateTime updateDateTime;
    private LocalDateTime createDateTime;

    @Builder
    public Panel(String panelId, long scanIndex, String equipType, String operator, LocalDateTime updateDateTime, LocalDateTime createDateTime) {
        this.panelId = panelId;
        this.scanIndex = scanIndex;
        this.equipType = equipType;
        this.operator = operator;
        this.updateDateTime = updateDateTime;
        this.createDateTime = createDateTime;
    }

    @Builder
    public Panel(String panelId, String equipType, long scanIndex) {
        this.panelId = panelId;
        this.equipType = equipType;
        this.scanIndex = scanIndex;
    }


    public void updateOperator(String name) {
        this.operator = name;
    }
}
