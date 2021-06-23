package br.com.mongodb.exception;

public class TurnNotFoundException extends RuntimeException {
    public TurnNotFoundException(String message) {
        super(message);
    }
}
