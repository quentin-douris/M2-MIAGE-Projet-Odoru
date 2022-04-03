package com.miage.odoru.projet.odorucoursservice.exceptions;

/**
 * Exception pour un éléve déjà inscrit à cours sur un créneau spécifique
 */
public class ParticipantDejaInscritException extends Exception {
    public ParticipantDejaInscritException(Long idCours, Long idCreneau, Long idParticipant) {
        super("L'élève avec l'identifiant : " + idParticipant + ", est déjà inscrit pour le cours " + idCours + " sur le creneau " + idCreneau);
    }
}
