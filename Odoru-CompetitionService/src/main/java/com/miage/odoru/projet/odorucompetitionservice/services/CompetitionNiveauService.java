package com.miage.odoru.projet.odorucompetitionservice.services;

import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionNiveau;

/**
 * Interface du service qui s'occupe de la gestion des résultat de competition pour un niveau
 */
public interface CompetitionNiveauService {

    /**
     * Méthode permettant d'obtenir le nombre de compétitions pour un niveau
     * @param idNiveau
     * @return
     */
    public CompetitionNiveau getCompetitionNiveauStats(int idNiveau);
}
