package com.miage.odoru.projet.odorucompetitionservice.services;

import com.miage.odoru.projet.odorucompetitionservice.clients.OdoroUtilisateurServiceClient;
import com.miage.odoru.projet.odorucompetitionservice.definitions.Utilisateur;
import com.miage.odoru.projet.odorucompetitionservice.entities.Competition;
import com.miage.odoru.projet.odorucompetitionservice.entities.Participant;
import com.miage.odoru.projet.odorucompetitionservice.exceptions.EnseignantMauvaisNiveauException;
import com.miage.odoru.projet.odorucompetitionservice.exceptions.MauvaiseDateException;
import com.miage.odoru.projet.odorucompetitionservice.repositories.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    CompetitionRepository competitionRepository;

    @Autowired
    OdoroUtilisateurServiceClient odoruUtilisateurServiceClient;

    @Autowired
    MongoOperations mongoOperations;

    /**
     * Méthode permettant d'ajouter une competition
     * @param competition
     * @return
     */
    @Override
    public Competition ajouterCompetition(Competition competition) throws MauvaiseDateException, ParseException, EnseignantMauvaisNiveauException {
        // Vérification que la date de la competition est supérieure à 7 jours
        // Conversion de la date en paramètre de la route
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss") ;
        Date dateconvert = df.parse(competition.getDate());

        // Conversion de la date du jour + 7
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss'Z'");

        Date date = new Date();
        String todate = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +7);
        Date todateDateFuture = cal.getTime();
        // Verif
        if (dateconvert.before(todateDateFuture)) {
            throw new MauvaiseDateException(dateconvert.toString());
        }
        // Vérification que l'enseignant est apte à créer le cours
        Utilisateur enseignant = this.odoruUtilisateurServiceClient.getUtilisateur(competition.getIdEnseignant());
        if(enseignant.getIdNiveau() < competition.getIdNiveau()) {
            throw new EnseignantMauvaisNiveauException(enseignant.getId());
        }
        // Ajout par défaut aux participants de la compétition tous les membres d'un même niveau que la compet (sauf l'enseignant)
        Iterable<Utilisateur> utilisateurList = this.odoruUtilisateurServiceClient.getUtilisateurByIdNiveau(competition.getIdNiveau());
        for (Iterator<Utilisateur> utilisateurIterator = utilisateurList.iterator(); utilisateurIterator.hasNext();) {
            Utilisateur utilisateur = utilisateurIterator.next();
            if (!utilisateur.getId().equals(enseignant.getId())) {
                // Créer un nouveau participant
                Participant newParticipant = new Participant();
                newParticipant.setIdEleve(utilisateur.getId());
                // Ajout le participant à la compétition
                competition.getParticipants().add(newParticipant);
            }
        }
        //Ajout de la compétition
        return this.competitionRepository.save(competition);
    }

    /**
     * Méthode permettant d'obtenir les compétitions
     * @return
     */
    @Override
    public Iterable<Competition> obtenirLesCompetitions() {
        return this.competitionRepository.findAll();
    }

    /**
     * Méthode permettant d'obtenir les compétitions selon un niveau
     * @param idNiveau
     * @return
     */
    @Override
    public Iterable<Competition> obtenirLesCompetitionsSelonNiveau(int idNiveau) {
        return this.mongoOperations.query(Competition.class)
                .matching(query(where("idNiveau").is(idNiveau)))
                .all();
    }

    /**
     * Méthode permettant d'obtenir les compétitions selon un enseignant
     * @param idEnseignant
     * @return
     */
    @Override
    public Iterable<Competition> obtenirLesCompetitionsSelonEnseignant(long idEnseignant) {
        return this.mongoOperations.query(Competition.class)
                .matching(query(where("idEnseignant").is(idEnseignant)))
                .all();
    }

    /**
     * Méthode permettant d'obtenir les compétitions selon un id de participant (idEleve)
     * @param idParticipant
     * @return
     */
    @Override
    public Iterable<Competition> obtenirLesCompetitionsSelonParticipant(int idParticipant) {
        return this.mongoOperations.query(Competition.class)
                .matching(query(where("participants.idEleve").is(idParticipant)))
                .all();
    }

    /**
     * Méthode permettant de mettre à jour le résultat d'une compétition pour un participant
     * @param idCompetition
     * @param idParticipant
     * @param resultat
     * @return
     */
    @Override
    public Competition miseAJourResultatCompetition(int idCompetition, int idParticipant, double resultat) {
         List<Competition> comp = this.mongoOperations.query(Competition.class)
                .matching(query(where("id").is(idCompetition).and("participants.idEleve").is(idParticipant)))
                .all();
         for (int i = 0; i < comp.size(); i++) {
             List<Participant> part = comp.get(i).getParticipants();
             for (int j = 0; j < part.size(); j ++) {
                 if (part.get(j).getIdEleve() == idParticipant) {
                     part.get(j).setResultat(resultat);
                 }
             }
         }
        this.competitionRepository.save(comp.get(0));
        return comp.get(0);
    }
}
