package com.miage.odoru.projet.odorustatistiqueservice.services;

import com.miage.odoru.projet.odorustatistiqueservice.transientobj.CompetitionResultatTransient;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCompetitionNiveau;

/**
 * Interface du service qui s'occupe de la gestion des statistiques des Compétitions
 */
public interface CompetitionStatistiqueService {
    /**
     * Calcul le nombre de compétition enregistré selon le niveau
     * @param idNiveau
     * @return
     */
    StatistiqueCompetitionNiveau obtenirStatistiqueNbCompetitionPourNiveau(Long idNiveau);

    /**
     * Calcul les résultats obtenu par un élève pour chacune des compétitions à laquelle il a participé
     * @param idEleve
     * @return
     */
    Iterable<CompetitionResultatTransient> obtenirStatistiqueCompetitionAvecResultatPourEleve(Long idEleve);
}
