package org.sample.common.exeption;

import lombok.extern.slf4j.Slf4j;
import org.sample.common.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // data return
@ControllerAdvice // 모든 controller의 execption을 낚아챔
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<CMRespDto<?>> validationApiException(CustomValidationApiException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(new CMRespDto<>("OK", e.getMessage(), null, e.getErrorMap()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<CMRespDto<?>> apiException(CustomApiException e) {
        log.info(e.getMessage());
        if (e.getHttpStatus() == null) {
            return new ResponseEntity<>(new CMRespDto<>("OK", e.getMessage(), null, null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new CMRespDto<>("OK", e.getMessage(), null, null),
                e.getHttpStatus());
    }

}
