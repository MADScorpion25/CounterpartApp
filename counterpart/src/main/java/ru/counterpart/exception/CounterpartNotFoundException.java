package ru.counterpart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CounterpartNotFoundException extends RuntimeException {

    public CounterpartNotFoundException(String message, Object... args) {
        super(String.format(message, args));
    }
}
