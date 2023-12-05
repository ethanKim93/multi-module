package org.sample.application.domain.model;

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
    public Panel(String panelId, String equipType, long scanIndex) {
        this.panelId = panelId;
        this.equipType = equipType;
        this.scanIndex = scanIndex;
    }

    public void updateOperator(String name) {
        this.operator = name;
    }
}
