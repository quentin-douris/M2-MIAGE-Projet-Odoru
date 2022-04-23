package com.miage.odoru.projet.odorubadgeservice.rest;

import com.miage.odoru.projet.odorubadgeservice.exceptions.BadgeDejaAjouteException;
import com.miage.odoru.projet.odorubadgeservice.exceptions.BadgeInconnuException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManager {

    /**
     * Manager de l'exception Badge déjà ajouté à l'utilisateur
     * @param request
     * @param badgeDejaAjouteException
     * @return
     */
    @ExceptionHandler(BadgeDejaAjouteException.class)
    public ResponseEntity<String> manageBadgeDejaAjouteException(
            HttpServletRequest request,
            BadgeDejaAjouteException badgeDejaAjouteException)
    {
        return new ResponseEntity<>(badgeDejaAjouteException.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Manager de l'exception Badge inconnu
     * @param request
     * @param badgeInconnuException
     * @return
     */
    @ExceptionHandler(BadgeInconnuException.class)
    public ResponseEntity<String> manageBadgeInconnuException(
            HttpServletRequest request,
            BadgeInconnuException badgeInconnuException)
    {
        return new ResponseEntity<>(badgeInconnuException.getMessage(),
                HttpStatus.NOT_FOUND);
    }
}
