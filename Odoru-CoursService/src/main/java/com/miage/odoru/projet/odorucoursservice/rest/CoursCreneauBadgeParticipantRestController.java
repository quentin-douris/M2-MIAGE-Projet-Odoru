package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.exceptions.BadgeInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.CreneauInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.ParticipantNonInscrit;
import com.miage.odoru.projet.odorucoursservice.services.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/{idcours}/creneau/{idcreneau}/badge/{idbadge}")
public class CoursCreneauBadgeParticipantRestController {
    Logger logger = LoggerFactory.getLogger(CoursRestController.class);

    @Autowired
    ParticipantService participantService;

    /**
     * Enresitre la participation d'un élève à un cours
     * @param optionalCours
     * @param idCours
     * @param idCreneau
     * @param idBadge
     * @throws CoursInconnuException
     * @throws CreneauInconnuException
     * @throws ParticipantNonInscrit
     * @throws BadgeInconnuException
     */
    @PutMapping
    public void putOne(@PathVariable("idcours") Optional<Cours> optionalCours, @PathVariable("idcours") Long idCours, @PathVariable("idcreneau") Long idCreneau, @PathVariable("idbadge") Long idBadge) throws CoursInconnuException, CreneauInconnuException, ParticipantNonInscrit, BadgeInconnuException {
        // Vérifie que le cours existe
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(idCours);
        }

        this.logger.info("CoursCreneauBadgeParticipant : enregistrement de la présence pour le participant avec le badge n° " + idBadge + " sur le cours : " + idCours + " pour le creneau " + idCreneau);
        this.participantService.enregistrePresenceMembreCoursCreneau(optionalCours.get(), idCreneau, idBadge);
    }
}
