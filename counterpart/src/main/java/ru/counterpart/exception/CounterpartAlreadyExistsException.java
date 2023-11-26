package ru.counterpart.exception;

public class CounterpartAlreadyExistsException extends RuntimeException {

    public CounterpartAlreadyExistsException(String message, Object... args) {
        super(String.format(message, args));
    }
}
