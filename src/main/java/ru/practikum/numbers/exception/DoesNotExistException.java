package ru.practikum.numbers.exception;

public class DoesNotExistException extends RuntimeException {
    public DoesNotExistException(final String message) {
        super(message);
    }
}