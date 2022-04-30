package com.miage.odoru.projet.odorucompetitioncompositeservice.services;

import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.CompetitionParticipantTransient;

/**
 * Interface du service qui s'occupe de la gestion des Competition avec leur détail
 */
public interface CompetitionUtilisateurService {

    Iterable<CompetitionParticipantTransient> obtenirCompetitionDetail();

    Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailSelonNiveau(int idNiveau);
}
