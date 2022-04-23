package com.miage.odoru.projet.odorucourscompositeservice.repositories;

import com.miage.odoru.projet.odorucourscompositeservice.transientobj.CoursTransient;
import org.springframework.stereotype.Repository;

/**
 * Interface qui permet de manipuler techniquement nos objets provenant des autres services
 */
@Repository
public interface CoursUtilisateurRepository {
    /**
     * Recherche tous les cours et les utilisateurs pour construire un cours avec son détail
     * @return
     */
    Iterable<CoursTransient> getAllCoursDetail();

    /**
     * Recherche tous les cours selon le niveau et les utilisateurs pour construire un cours avec son détail
     * @param idNiveau
     * @return
     */
    Iterable<CoursTransient> getAllCoursDetailByIdNiveau(int idNiveau);

    /**
     * Recherche tous les cours avec les créneaux d'un enseignant pour construire un cours avec son détail
     * @param idEnseignant
     * @return
     */
    Iterable<CoursTransient> getAllCreneauDetailByIdEnseignant(int idEnseignant);
}
