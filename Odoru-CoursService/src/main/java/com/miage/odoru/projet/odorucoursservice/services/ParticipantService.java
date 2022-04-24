package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Participant;
import com.miage.odoru.projet.odorucoursservice.exceptions.*;

/**
 * Interface du service qui s'occupe de la gestion des Participants
 */
public interface ParticipantService {
    /**
     * Ajoute un participant à un cours sur un créneau spécifique
     * @param cours
     * @param idCreneau
     * @param participant
     * @return
     */
    Cours ajouterParticipantCours(Cours cours, Long idCreneau, Participant participant) throws CoursInconnuException, CreneauInconnuException, ParticipantDejaInscritException;

    /**
     * Enregistre la participation d'un élève / membre à un cours dans le système
     * @param cours
     * @param idCreneau
     * @param idBadge
     * @throws CoursInconnuException
     * @throws CreneauInconnuException
     * @throws ParticipantNonInscrit
     * @throws BadgeInconnuException
     */
    void enregistrePresenceMembreCoursCreneau(Cours cours, Long idCreneau, Long idBadge) throws CoursInconnuException, CreneauInconnuException, ParticipantNonInscrit, BadgeInconnuException;
}
