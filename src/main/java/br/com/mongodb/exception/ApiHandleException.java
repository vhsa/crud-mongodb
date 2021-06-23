package br.com.mongodb.exception;

import br.com.mongodb.dto.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class ApiHandleException {

    @ExceptionHandler(TurnNotFoundException.class)
    public ErrorDTO handleTurnNotFoundException ( TurnNotFoundException ex ) {
        return new ErrorDTO(Arrays.asList(ex.getMessage()));
    }
}
