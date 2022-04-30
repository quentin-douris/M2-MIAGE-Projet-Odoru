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

    /**
     * Rechercher toutes les compétitions avec le détail selon niveau
     * @param idNiveau
     * @return
     */
    Iterable<CompetitionParticipantTransient> getAllCompetitionsDetailByIdNiveau(int idNiveau);

    /**
     * Rechercher toutes les compétitions avec le détail selon l'id enseignant
     * @param idEnseignant
     * @return
     */
    Iterable<CompetitionParticipantTransient> getAllCompetitionDetailByIdEnseignant(int idEnseignant);

    /**
     * Recherche toutes les compétitions avec le détail selon l'id participant
     * @param idParticipant
     * @return
     */
    Iterable<CompetitionParticipantTransient> getAllCompetitionDetailByIdParticipant(int idParticipant);
}
