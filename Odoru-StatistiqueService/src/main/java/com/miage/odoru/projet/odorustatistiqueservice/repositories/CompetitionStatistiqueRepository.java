package com.miage.odoru.projet.odorustatistiqueservice.repositories;

import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCompetitionNiveau;

/**
 * Interface qui permet de manipuler techniquement nos objets provenant du service Compétition
 */
public interface CompetitionStatistiqueRepository {
    /**
     * Calcul le nombre le nombre de compétition enregistrée selon le niveau.
     * @param idNiveau
     * @return
     */
    StatistiqueCompetitionNiveau getStatistiqueNbCompetitionPourNiveau(Long idNiveau);
}
