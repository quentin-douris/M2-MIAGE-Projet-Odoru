package com.miage.odoru.projet.odorucourscompositeservice.services;

import com.miage.odoru.projet.odorucourscompositeservice.transientobj.CoursTransient;

/**
 * Interface du service qui s'occupe de la gestion des Cours avec leur détail
 */
public interface CoursUtilisateurService {
    /**
     * Retourne tous les cours détaillés enregistrés dans le système
     * @return
     */
    Iterable<CoursTransient> obtenirCoursDetail();

    /**
     * Retourne tous les cours détaillés selon un identifiant de niveau
     * @param idNiveau
     * @return
     */
    Iterable<CoursTransient> obtenirCoursDetailSelonNiveau(int idNiveau);

    /**
     * Retourne tous les cours avec les créneaux d'un enseignant
     * @param idEnseignant
     * @return
     */
    Iterable<CoursTransient> obtenirCreneauxDetailEnseignant(int idEnseignant);
}
