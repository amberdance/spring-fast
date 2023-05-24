package ru.hard2code.exception;

public class AccountNotFoundException extends ApiException {
    public AccountNotFoundException() {
        super(Message.ACCOUNT_NOT_FOUND);
    }
}
