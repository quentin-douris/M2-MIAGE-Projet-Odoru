package com.miage.odoru.projet.odorucompetitioncompositeservice.repositories;

import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.CompetitionParticipantTransient;
import org.springframework.stereotype.Repository;

/**
 * Interface qui permet de manipuler techniquement nos objets provenant des autres services
 */
@Repository
public interface CompetitionUtilisateurRepository {
    /**
     * Rechercher toutes les competitions avec le détail
     * @return
     */
    Iterable<CompetitionParticipantTransient> getAllCompetitionDetail();

    Iterable<CompetitionParticipantTransient> getAllCompetitionsDetailByIdNiveau(int idNiveau);
}
