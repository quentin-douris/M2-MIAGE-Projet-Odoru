package com.miage.odoru.projet.odorucoursservice.exceptions;

/**
 * Exception pour un cours inconnu du système
 */
public class CoursInconnuException extends Exception {
    public CoursInconnuException(Long idCours) {
        super("Le cours demandé avec l'identifiant " + idCours +", n'est pas enregistré dans le système.");
    }
}
