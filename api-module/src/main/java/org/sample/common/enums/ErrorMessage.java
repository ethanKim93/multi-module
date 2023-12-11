package org.sample.common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {
    //Panel_id
    NOT_FOUND_PANEL(HttpStatus.NOT_FOUND, "NOT FOUND PANEL"),
    FAIL_WRITE_FILE(HttpStatus.INTERNAL_SERVER_ERROR, "File Write Fail"),
    MODULE_STATE_NOT_CONNECT(HttpStatus.SERVICE_UNAVAILABLE, "CIM State IS NOT CONNECT");

    private HttpStatus httpStatue;
    private String message;

    private ErrorMessage(HttpStatus httpStatue, String message) {
        this.httpStatue = httpStatue;
        this.message = message;
    }

}
