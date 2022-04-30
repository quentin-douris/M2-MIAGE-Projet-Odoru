package com.miage.odoru.projet.odorucompetitionservice.rest;

import com.miage.odoru.projet.odorucompetitionservice.entities.Competition;
import com.miage.odoru.projet.odorucompetitionservice.entities.Participant;
import com.miage.odoru.projet.odorucompetitionservice.exceptions.EnseignantMauvaisNiveauException;
import com.miage.odoru.projet.odorucompetitionservice.exceptions.MauvaiseDateException;
import com.miage.odoru.projet.odorucompetitionservice.services.CompetitionService;
import com.miage.odoru.projet.odorucompetitionservice.services.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CompetitionRestController {
    Logger logger = LoggerFactory.getLogger(CompetitionRestController.class);

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    CompetitionService competitionService;

    /**
     * Méthode permettant d'ajouter une compétition
     * @param competition
     * @return
     */
    @PostMapping
    public Competition postOne(@RequestBody Competition competition) throws ParseException, MauvaiseDateException, EnseignantMauvaisNiveauException {
        this.logger.info("Competition : ajouter une nouvelle competition dans le système.");
        // Récupère l'identifiant de la compétition selon la séquence
        competition.setId(sequenceGeneratorService.generateSequence(Competition.SEQUENCE_NAME));
        return this.competitionService.ajouterCompetition(competition);
    }

    /**
     * Méthode permettant d'obtenir toutes les compétitions
     * @return
     */
    @GetMapping
    public Iterable<Competition> getAll(@RequestParam("idniveau") Optional<Integer> idNiveau, @RequestParam("idenseignant") Optional<Integer> idEnseignant, @RequestParam("idparticipant") Optional<Integer> idParticipant) {
        // Retourne les competitions selon leur niveau
        if (idNiveau.isPresent()) {
            this.logger.info("Competition : demande la liste de tous les cours selon le niveau : " + idNiveau);
            return this.competitionService.obtenirLesCompetitionsSelonNiveau(idNiveau.get());
        }
        // Retourne les competitions d'un enseignant
        if (idEnseignant.isPresent()) {
            this.logger.info("Competition : demande la liste de toutes les compétitions dispensés par l'enseignant : " + idEnseignant);
            return this.competitionService.obtenirLesCompetitionsSelonEnseignant(idEnseignant.get());
        }
        // Retourne les compétitions d'un participant
        if (idParticipant.isPresent()) {
            this.logger.info("Competition : demande la liste de toutes les compétitions du participant " + idParticipant);
            return this.competitionService.obtenirLesCompetitionsSelonParticipant(idParticipant.get());
        }
        // Retourne toutes les compétitions du système
        return this.competitionService.obtenirLesCompetitions();
    }

    /**
     * Méthode permettant de mettre à jour le résultat d'une compétition pour un participant
     * @param participant
     * @param idCompetition
     * @param idParticipant
     * @return
     */
    @PutMapping("/{idcompetition}/participant/{idparticipant}")
    public Competition ajoutResultat(@RequestBody Participant participant, @PathVariable("idcompetition") Optional<Integer> idCompetition, @PathVariable("idparticipant") Optional<Integer> idParticipant) {
        return this.competitionService.miseAJourResultatCompetition(idCompetition.get(), idParticipant.get(), participant.getResultat());
    }
}
