package com.dog.it.exception.exceptions;

public class FriendlyException  extends Exception{
    public FriendlyException(String message) {
        super(message);
    }

    public FriendlyException(String message, Throwable cause) {
        super(message, cause);
    }
}
