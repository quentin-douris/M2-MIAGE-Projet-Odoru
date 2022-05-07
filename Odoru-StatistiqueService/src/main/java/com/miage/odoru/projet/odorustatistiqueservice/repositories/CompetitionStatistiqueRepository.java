package com.miage.odoru.projet.odorustatistiqueservice.repositories;

import com.miage.odoru.projet.odorustatistiqueservice.transientobj.CompetitionResultatTransient;
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

    /**
     * Calcul le résultat d'un élève à toutes les compétitions auxquelles il a participé
     * @param idParticipant
     * @return
     */
    Iterable<CompetitionResultatTransient> obtenirResultatsCompetition(Long idParticipant);

}
