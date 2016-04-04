package com.theyavikteam.mockatacore.exceptions;

public class MockConstructorException extends Exception {

    public MockConstructorException() {
        super("@MockConstructor annotation not found at any constructor");
    }
}