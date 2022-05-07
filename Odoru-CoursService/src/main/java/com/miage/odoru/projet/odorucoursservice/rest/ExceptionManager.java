package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.exceptions.*;
import feign.FeignException;
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

    /**
     * Gestionnaire de l'exception CreneauInconnuException.
     * @param request
     * @param creneauInconnuException
     * @return
     */
    @ExceptionHandler(CreneauInconnuException.class)
    public ResponseEntity<String> manageCreneauInconnuException(
            HttpServletRequest request,
            CreneauInconnuException creneauInconnuException)
    {
        return new ResponseEntity<>(creneauInconnuException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Gestionnaire de l'exception ParticipantDejaInscritException.
     * @param request
     * @param participantDejaInscritException
     * @return
     */
    @ExceptionHandler(ParticipantDejaInscritException.class)
    public ResponseEntity<String> manageParticipantDejaInscritException(
            HttpServletRequest request,
            ParticipantDejaInscritException participantDejaInscritException)
    {
        return new ResponseEntity<>(participantDejaInscritException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Gestionnaire de l'exception PlanificationCreneauException.
     * @param request
     * @param planificationCreneauException
     * @return
     */
    @ExceptionHandler(PlanificationCreneauException.class)
    public ResponseEntity<String> managePlanificationCreneauException(
            HttpServletRequest request,
            PlanificationCreneauException planificationCreneauException)
    {
        return new ResponseEntity<>(planificationCreneauException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Gestionnaire de l'exception EnseignantInapteException.
     * @param request
     * @param enseignantInapteException
     * @return
     */
    @ExceptionHandler(EnseignantInapteException.class)
    public ResponseEntity<String> manageEnseignantInapteException(
            HttpServletRequest request,
            EnseignantInapteException enseignantInapteException)
    {
        return new ResponseEntity<>(enseignantInapteException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

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
