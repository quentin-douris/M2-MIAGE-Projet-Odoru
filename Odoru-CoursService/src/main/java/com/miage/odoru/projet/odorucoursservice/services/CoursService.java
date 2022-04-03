package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;

/**
 * Interface du service qui s'occupe de la gestion des Cours
 */
public interface CoursService {
    /**
     * Créer un nouveau cours dans le système
     * @param cours
     * @return
     */
    Cours ajouterCours(Cours cours);

    /**
     * Retourne tous les cours enregistrés dans le système
     * @return
     */
    Iterable<Cours> obtenirCours();
}
