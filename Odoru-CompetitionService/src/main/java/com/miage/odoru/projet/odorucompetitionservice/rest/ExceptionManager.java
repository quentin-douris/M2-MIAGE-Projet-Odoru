package com.miage.odoru.projet.odorucompetitionservice.rest;

import com.miage.odoru.projet.odorucompetitionservice.exceptions.MauvaiseDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(MauvaiseDateException.class)
    public ResponseEntity<String> manageMauvaiseDateException(
            HttpServletRequest request,
            MauvaiseDateException mauvaiseDateException)
    {
        return new ResponseEntity<>(mauvaiseDateException.getMessage(),
                HttpStatus.BAD_REQUEST);
    }
}
