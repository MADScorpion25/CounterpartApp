package ru.report.report.exception;

import java.util.Objects;

public class ReportCreateException extends RuntimeException {

    public ReportCreateException(String message, Objects ...args) {
        super(String.format(message, args));
    }
}
