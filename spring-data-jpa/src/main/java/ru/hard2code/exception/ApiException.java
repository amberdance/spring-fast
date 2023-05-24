package ru.hard2code.exception;

public class ApiException extends RuntimeException {

    public ApiException() {
        super(Message.DEFAULT_ERROR);
    }

    public ApiException(String message) {
        super(message);
    }
}
