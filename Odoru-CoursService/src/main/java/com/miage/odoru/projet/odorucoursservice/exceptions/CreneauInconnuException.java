package com.miage.odoru.projet.odorucoursservice.exceptions;

/**
 * Exception pour un créneau inconnu pour un cours dans le système
 */
public class CreneauInconnuException extends Exception {
    public CreneauInconnuException(Long idCours, Long idCreneau) {
        super("Le créneau demandé avec l'identifiant " + idCreneau +", pour le cours avec l'identifiant " + idCours + ", n'est pas enregistré dans le système.\"");
    }
}
