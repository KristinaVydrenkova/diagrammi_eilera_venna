package ru.itis.semesterwork2.exceptions;

public class NoSuchEmailException extends RuntimeException{
    public NoSuchEmailException() {
    }

    public NoSuchEmailException(String message) {
        super(message);
    }

    public NoSuchEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchEmailException(Throwable cause) {
        super(cause);
    }
}
