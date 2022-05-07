package com.miage.odoru.projet.odorucourscompositeservice.rest;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManager {

    /**
     * Gestionnaire de l'exception Générique pour les appels aux autres services
     * @param request
     * @param feignException
     * @return
     */
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> manageCoursInconnuException(
            HttpServletRequest request,
            FeignException feignException)
    {
        return new ResponseEntity<>(feignException.getMessage(),
                HttpStatus.NOT_FOUND);
    }
}
