package ru.hard2code.exception;

public class AmountExceedException extends ApiException {
    public AmountExceedException() {
        super(Message.AMOUNT_EXCEED);
    }
}
