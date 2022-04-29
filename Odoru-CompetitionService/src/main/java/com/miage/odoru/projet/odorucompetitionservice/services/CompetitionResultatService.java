package com.miage.odoru.projet.odorucompetitionservice.services;

import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionResultat;

/**
 * Interface du service qui s'occupe de la gestion des résultat de competition pour un participant
 */
public interface CompetitionResultatService {

    /**
     * Permet d'obtenir l'ensemble des résultats aux compétitions pour un participant
     * @param idParticipant
     * @return
     */
    Iterable<CompetitionResultat> obtenirResultatsCompetition(int idParticipant);
}
