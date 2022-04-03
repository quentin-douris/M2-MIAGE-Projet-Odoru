package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManager {

    /**
     * Gestionnaire de l'exception CoursInconnuException.
     * @param request
     * @param coursInconnuException
     * @return
     */
    @ExceptionHandler(CoursInconnuException.class)
    public ResponseEntity<String> manageCoursInconnuException(
            HttpServletRequest request,
            CoursInconnuException coursInconnuException)
    {
        return new ResponseEntity<>(coursInconnuException.getMessage(),
                HttpStatus.NOT_FOUND);
    }
}
