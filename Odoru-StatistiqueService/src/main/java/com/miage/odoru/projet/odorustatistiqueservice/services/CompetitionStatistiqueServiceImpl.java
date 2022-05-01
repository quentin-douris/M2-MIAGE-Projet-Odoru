package com.miage.odoru.projet.odorustatistiqueservice.services;

import com.miage.odoru.projet.odorustatistiqueservice.repositories.CompetitionStatistiqueRepository;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCompetitionNiveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des statistiques pour les Compétitions
 */
@Service
public class CompetitionStatistiqueServiceImpl implements CompetitionStatistiqueService {
    @Autowired
    CompetitionStatistiqueRepository competitionStatistiqueRepository;

    /**
     * Calcul le nombre de compétition enregistré selon le niveau
     * @param idNiveau
     * @return
     */
    @Override
    public StatistiqueCompetitionNiveau obtenirStatistiqueNbCompetitionPourNiveau(Long idNiveau) {
        return this.competitionStatistiqueRepository.getStatistiqueNbCompetitionPourNiveau(idNiveau);
    }
}
