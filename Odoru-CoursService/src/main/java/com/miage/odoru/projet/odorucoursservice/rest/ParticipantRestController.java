package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Participant;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.CreneauInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.ParticipantDejaInscritException;
import com.miage.odoru.projet.odorucoursservice.services.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/{idcours}/creneau/{idcreneau}/participant")
public class ParticipantRestController {
    Logger logger = LoggerFactory.getLogger(ParticipantRestController.class);

    @Autowired
    ParticipantService participantService;

    @PostMapping
    public Cours postOne(@PathVariable("idcours") Optional<Cours> optionalCours, @PathVariable("idcours") Long idCours, @PathVariable("idcreneau") Long idCreneau, @RequestBody Participant participant) throws CoursInconnuException, CreneauInconnuException, ParticipantDejaInscritException {
        // Vérifie l'existance du cours
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(idCours);
        }
        // Enregistre le nouveau participant
        this.logger.info("Participant : ajout du participant " + participant.getIdEleve() + " au cours " + idCours + " sur le creneau " + idCreneau);
        return this.participantService.ajouterParticipantCours(optionalCours.get(), idCreneau, participant);
    }
}
