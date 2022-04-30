package com.miage.odoru.projet.odorucompetitionservice.services;

import com.google.common.collect.Iterators;
import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionNiveau;
import com.miage.odoru.projet.odorucompetitionservice.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CompetitionNiveauServiceImpl implements CompetitionNiveauService {

    @Autowired
    CompetitionService competitionService;

    /**
     * Permet d'obtenir le nombre de compétitions pour un niveau donné (statistique)
     * @param idNiveau
     * @return
     */
    @Override
    public CompetitionNiveau getCompetitionNiveauStats(int idNiveau) {
        CompetitionNiveau nbCompetitionParNiveau = new CompetitionNiveau();
        Iterable<Competition> listCompParNiveau = this.competitionService.obtenirLesCompetitionsSelonNiveau(idNiveau);
        int counter = 0;
        for (Competition c : listCompParNiveau) {
            counter++;
        }
        nbCompetitionParNiveau.setNbCompetitionNiveau(counter);
        return nbCompetitionParNiveau;
    }
}
