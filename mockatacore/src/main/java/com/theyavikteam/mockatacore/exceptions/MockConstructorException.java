package com.theyavikteam.mockatacore.exceptions;

public class MockConstructorException extends Exception {

    public MockConstructorException() {
        super("@MockConstructor annotation not found at any constructor");
    }

    public MockConstructorException(String message) {
        super(message);
    }

    public MockConstructorException(String message, Throwable throwable) {
        super(message, throwable);
    }

}