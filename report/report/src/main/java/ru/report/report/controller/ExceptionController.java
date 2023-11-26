package ru.report.report.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.report.report.domain.exception.ErrorResponse;
import ru.report.report.exception.ReportCreateException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ReportCreateException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST));
    }

    private ErrorResponse createResponse(String message, HttpStatus status) {
        return ErrorResponse.builder()
                .message(message)
                .status(status)
                .time(LocalDateTime.now())
                .build();
    }
}
