package com.miage.odoru.projet.odoruutilisateurservice.rest;

import com.miage.odoru.projet.odoruutilisateurservice.exceptions.*;
import org.bouncycastle.crypto.util.DERMacData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManager {

    /**
     * Manager de l'exeption utilisateur inconnu
     * @param request
     * @param utilisateurInconnuException
     * @return
     */
    @ExceptionHandler(UtilisateurInconnuException.class)
    public ResponseEntity<String> manageUtilisateurInconnuException(
            HttpServletRequest request,
            UtilisateurInconnuException utilisateurInconnuException)
    {
        return new ResponseEntity<>(utilisateurInconnuException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Manager de l'exception login déjà existant
     * @param request
     * @param loginExistantException
     * @return
     */
    @ExceptionHandler(LoginExistantException.class)
    public ResponseEntity<String> manageLoginExistantException(
            HttpServletRequest request,
            LoginExistantException loginExistantException)
    {
        return new ResponseEntity<>(loginExistantException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Manager de l'exception niveau incorrect
     * @param request
     * @param niveauIncorrectException
     * @return
     */
    @ExceptionHandler(NiveauIncorrectException.class)
    public ResponseEntity<String> NiveauIncorrectException(
            HttpServletRequest request,
            NiveauIncorrectException niveauIncorrectException)
    {
        return new ResponseEntity<>(niveauIncorrectException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Manager de l'exception type incorrect
     * @param request
     * @param typeIncorrectException
     * @return
     */
    @ExceptionHandler(TypeIncorrectException.class)
    public ResponseEntity<String> TypeIncorrectException(
            HttpServletRequest request,
            TypeIncorrectException typeIncorrectException)
    {
        return new ResponseEntity<>(typeIncorrectException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Méthode permettant de gérer l'exception utilisateur login
     * @param request
     * @param utilisateurLoginException
     * @return
     */
    @ExceptionHandler(UtilisateurLoginException.class)
    public ResponseEntity<String> UtilisateurLoginException(
            HttpServletRequest request,
            UtilisateurLoginException utilisateurLoginException)
    {
        return new ResponseEntity<>(utilisateurLoginException.getMessage(),
                HttpStatus.NOT_FOUND);
    }

}
