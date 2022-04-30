package com.miage.odoru.projet.odorucompetitioncompositeservice.repositories;

import com.miage.odoru.projet.odorucompetitioncompositeservice.clients.OdoruCompetitionServiceClient;
import com.miage.odoru.projet.odorucompetitioncompositeservice.clients.OdoruUtilisateurServiceClient;
import com.miage.odoru.projet.odorucompetitioncompositeservice.definitions.Competition;
import com.miage.odoru.projet.odorucompetitioncompositeservice.definitions.Participant;
import com.miage.odoru.projet.odorucompetitioncompositeservice.definitions.Utilisateur;
import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.CompetitionParticipantTransient;
import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.ParticipantTransient;
import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.UtilisateurTransient;
import com.netflix.discovery.converters.Auto;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
public class CompetitionUtilisateurRepositoryImpl implements CompetitionUtilisateurRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OdoruCompetitionServiceClient odoruCompetitionServiceClient;

    @Autowired
    private OdoruUtilisateurServiceClient odoruUtilisateurServiceClient;

    @Override
    public Iterable<CompetitionParticipantTransient> getAllCompetitionDetail() {
        this.logger.info("Obtenir toutes les compétitions enregistrées dans le système avec le détail de leurs informations");

        // Récupération de toutes les competitions auprès du service Competition
        this.logger.info("Demande les competitions au service CompetitionService");
        Iterable<Competition> competitionList = this.odoruCompetitionServiceClient.getAllCompetition();

        // Variable qui va contenir notre résultat
        List<CompetitionParticipantTransient> result = new ArrayList<>();

        // Construction de l'objet CompetitionParticipantTransient
        this.logger.info("Construction de la liste des CompetitionParticipantTransient.");
        for (Iterator<Competition> competitionIterator = competitionList.iterator(); competitionIterator.hasNext();) {
            Competition competition = competitionIterator.next();
            result.add(this.factoryCompetitionTransient(competition));
        }

        this.logger.info("Construction de la liste des CompetitionParticipantTransient terminée.");
        return result;
    }

    @Override
    public Iterable<CompetitionParticipantTransient> getAllCompetitionsDetailByIdNiveau(int idNiveau) {
        this.logger.info("Obtenir toutes les compétitions enregistrées dans le système selon leur idNiveau avec le détail de leurs informations");

        // Récupération de toutes les compétitions
        this.logger.info("Demande les cours selon leur idNiveau au service CompetitionService");
        Iterable<Competition> competitionList = this.odoruCompetitionServiceClient.getAllCompetitionsByIdNiveau(idNiveau);

        // Variable qui va contenir notre résultat
        List<CompetitionParticipantTransient> result = new ArrayList<>();

        // Construction de l'objet CompetitionParticipantTransient
        this.logger.info("Construction de la liste des CompetitionParticipantTransient.");
        for (Iterator<Competition> competitionIterator = competitionList.iterator(); competitionIterator.hasNext();) {
            Competition comp = competitionIterator.next();
            result.add(this.factoryCompetitionTransient(comp));
        }
        this.logger.info("Construction de la liste des CompetitionParticipantTransient terminée.");
        return result;
    }

    private CompetitionParticipantTransient factoryCompetitionTransient(Competition competition) {
        this.logger.info("Construction de l'objet CompetitionParticipantTransient avec l'id : " + competition.getId());
        
        // Initialisation du competitionParticipantTransient
        CompetitionParticipantTransient competitionParticipantTransient = new CompetitionParticipantTransient();
        competitionParticipantTransient.setId(competition.getId());
        competitionParticipantTransient.setDate(competition.getDate());
        competitionParticipantTransient.setDuree(competition.getDuree());
        competitionParticipantTransient.setNumSalle(competition.getNumSalle());
        competitionParticipantTransient.setIdNiveau(competition.getIdNiveau());

        // Recherche l'enseignant auprès du service Utilisateur
        this.logger.info("Demande le détail pour l'utilisateur type enseignant auprès de UtilisateurService avec l'id : " + competition.getIdEnseignant());
        Utilisateur enseignant = this.odoruUtilisateurServiceClient.getUtilisateur(competition.getIdEnseignant());
        // Construit l'enseignant (utilisateur) transient
        UtilisateurTransient enseignantTransient = new UtilisateurTransient();
        enseignantTransient.setId(enseignant.getId());
        enseignantTransient.setNom(enseignant.getNom());
        enseignantTransient.setPrenom(enseignant.getPrenom());
        enseignantTransient.setMail(enseignant.getMail());

        // Ajout de l'enseignant transient au creneau transient
        competitionParticipantTransient.setEnseignant(enseignantTransient);

        // Construction des participants transient
        for (Participant participant : competition.getParticipants()) {
            // Recherche l'élève auprès du service Utilisateur
            this.logger.info("Demande le détail pour l'utilisateur type élève auprès de UtilisateurService avec l'id : " + participant.getIdEleve());
            Utilisateur eleve = this.odoruUtilisateurServiceClient.getUtilisateur(participant.getIdEleve());

            // Construit le participant (utilisateur) transient
            ParticipantTransient participantTransient = new ParticipantTransient();
            participantTransient.setId(eleve.getId());
            participantTransient.setNom(eleve.getNom());
            participantTransient.setPrenom(eleve.getPrenom());
            participantTransient.setMail(eleve.getMail());
            participantTransient.setResultat(participant.getResultat());

            // Ajout du participant transient au creneau transient courant
            competitionParticipantTransient.getParticipants().add(participantTransient);
        }
        return competitionParticipantTransient;
    }
}
