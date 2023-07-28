package com.flow.hirework.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalCatcher {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        log.error("Custom Exception 발생 = {}", ex);

        ErrorCode errorCode = ex.getErrorCode();

        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.toErrorResponse(errorCode));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handledServerError(Exception e) {
        log.error("일반 서버 에러 발생");
        System.out.println(e);


        ErrorCode errorCode = ErrorCode.PERSONAL_INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.toErrorResponse(errorCode));
    }
}
