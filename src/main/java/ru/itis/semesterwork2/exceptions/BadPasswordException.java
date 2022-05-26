package ru.itis.semesterwork2.exceptions;

public class BadPasswordException extends RuntimeException {

    public BadPasswordException() {
    }

    public BadPasswordException(String message) {
        super(message);
    }

    public BadPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPasswordException(Throwable cause) {
        super(cause);
    }
}
