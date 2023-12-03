package org.sample.panel.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
public class Panel {

    private long panelId;
    private String name;
    private LocalDateTime updateDateTime;
    private LocalDateTime createDateTime;

    @Builder
    public Panel(long panelId, String name) {
        this.panelId = panelId;
        this.name = name;
    }

    public void updateOperator(String name) {
        this.name = name;
    }
}
