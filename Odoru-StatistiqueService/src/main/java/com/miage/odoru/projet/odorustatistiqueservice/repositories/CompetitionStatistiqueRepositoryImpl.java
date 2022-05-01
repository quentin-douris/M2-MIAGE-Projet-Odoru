package com.miage.odoru.projet.odorustatistiqueservice.repositories;

import com.miage.odoru.projet.odorustatistiqueservice.clients.OdoruCompetitionServiceClient;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Competition;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Cours;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCompetitionNiveau;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe qui permet de manipuler techniquement nos objets provenant du service Compétition
 */
@NoArgsConstructor
public class CompetitionStatistiqueRepositoryImpl implements CompetitionStatistiqueRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OdoruCompetitionServiceClient odoruCompetitionServiceClient;

    /**
     * Calcul le nombre le nombre de compétition enregistrée selon le niveau.
     * @param idNiveau
     * @return
     */
    @Override
    public StatistiqueCompetitionNiveau getStatistiqueNbCompetitionPourNiveau(Long idNiveau) {
        this.logger.info("Obtenir le nombre le nombre de compétition enregistrée selon le niveau");

        // Récupération de tous les cours auprès du service Cours
        this.logger.info("Demande les compétitions au service Compétitions selon le niveau");
        Iterable<Competition> competitionList = this.odoruCompetitionServiceClient.getCompetitionByIdNiveau(idNiveau);

        // Objet qui correspond à notre retour
        StatistiqueCompetitionNiveau result = new StatistiqueCompetitionNiveau();
        result.setNiveau(idNiveau);

        // Calcul le nombre de compétition
        int nbCompetition = 0;
        for (Competition c : competitionList) {
            nbCompetition++;
        }
        result.setNbCompetition(nbCompetition);

        return result;
    }
}
