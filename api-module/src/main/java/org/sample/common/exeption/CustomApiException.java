package org.sample.common.exeption;

import lombok.Getter;
import org.sample.common.enums.ErrorMessage;
import org.springframework.http.HttpStatus;

@Getter
public class CustomApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;

    public CustomApiException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.httpStatus = errorMessage.getHttpStatue();
    }

    public CustomApiException(String errorMessage) {
        super(errorMessage);
    }
}
