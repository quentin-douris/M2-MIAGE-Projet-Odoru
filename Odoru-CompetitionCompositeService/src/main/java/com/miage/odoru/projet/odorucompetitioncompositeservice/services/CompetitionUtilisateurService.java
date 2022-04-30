package com.miage.odoru.projet.odorucompetitioncompositeservice.services;

import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.CompetitionParticipantTransient;

/**
 * Interface du service qui s'occupe de la gestion des Competition avec leur détail
 */
public interface CompetitionUtilisateurService {

    /**
     * Obtenir toutes les compétitions avec des détails
     * @return
     */
    Iterable<CompetitionParticipantTransient> obtenirCompetitionDetail();

    /**
     * Obtenir toutes les compétitions avec des détails, selon le niveau
     * @param idNiveau
     * @return
     */
    Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailSelonNiveau(int idNiveau);

    /**
     * Obtenir toutes les compétitions avec des détails, selon un id d'enseignant de la competition
     * @param idEnseignant
     * @return
     */
    Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailEnseignant(int idEnseignant);

    /**
     * Obtenir toutes les compétitions avec des détails, selon un id de participant de la competition
     * @param idParticipant
     * @return
     */
    Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailParticipant(int idParticipant);
}
