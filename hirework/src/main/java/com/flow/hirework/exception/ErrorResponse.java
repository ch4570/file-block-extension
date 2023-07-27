package com.flow.hirework.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@EqualsAndHashCode
public class ErrorResponse {

    private final Integer status;
    private final String message;

    public ErrorResponse(HttpStatus status, String message) {
        this.message = message;
        this.status = status.value();
    }

    public static ErrorResponse toErrorResponse(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getHttpStatus(), errorCode.getMessage());
    }


}
