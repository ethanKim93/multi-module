package org.sample.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CMRespDto<T> {
    private String status;
    private String message;
    private Integer count;
    private T result;

    public CMRespDto(String status, String message, T result) {
        super();
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public CMRespDto(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
