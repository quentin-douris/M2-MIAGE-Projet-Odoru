package com.miage.odoru.projet.odorucoursservice.exceptions;

/**
 * Exception pour un participant qui badge pour un cours pour lequel il n'est pas inscrit
 */
public class ParticipantNonInscrit extends Exception {
    public ParticipantNonInscrit(Long idParticipant, Long idCours, Long idCreneau) {
        super("L'élève avec l'identifiant : " + idParticipant + ", n'est pas inscrit pour le cours " + idCours + " sur le creneau " + idCreneau);
    }
}
