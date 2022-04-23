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
}
