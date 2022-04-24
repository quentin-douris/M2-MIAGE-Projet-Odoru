package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.CreneauInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.ParticipantDejaInscritException;
import com.miage.odoru.projet.odorucoursservice.exceptions.PlanificationCreneauException;
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
     * Gestionnaire de l'exception ParticipantDejaInscritException.
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
}
