package com.miage.odoru.projet.odorucoursservice.exceptions;

/**
 * Exception pour badge inconnu
 */
public class BadgeInconnuException extends Exception {
    public BadgeInconnuException(Long idBadge) {
        super("Le badge avec l'id : " + idBadge +", n'est pas enregistré auprès du service badge.");
    }
}
