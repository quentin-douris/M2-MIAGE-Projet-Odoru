package com.miage.odoru.projet.odorucompetitionservice.services;

import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionResultat;
import com.miage.odoru.projet.odorucompetitionservice.entities.Competition;
import com.miage.odoru.projet.odorucompetitionservice.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CompetitionResultatServiceImpl implements CompetitionResultatService {

    @Autowired
    MongoOperations mongoOperations;
    /**
     * Permet d'obtenir les résultats des compétitions pour un utilisateur
     * @param idParticipant
     * @return
     */
    @Override
    public Iterable<CompetitionResultat> obtenirResultatsCompetition(int idParticipant) {
        List<CompetitionResultat> competitionsResultats = new ArrayList<>();
        List<Competition> compTpm = this.mongoOperations.query(Competition.class)
                .matching(query(where("participants.idEleve").is(idParticipant)))
                .all();
        for (Competition competition : compTpm) {
            for (Participant participant : competition.getParticipants()) {
                if (participant.getIdEleve() == idParticipant) {
                    CompetitionResultat compResult = new CompetitionResultat();
                    compResult.setIdCompetition((int) competition.getId());
                    compResult.setResultat(participant.getResultat());
                    competitionsResultats.add(compResult);
                }
            }
        }
        return competitionsResultats;
    }
}
