package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;

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

    /**
     * Retourne un cours selon son identifiant
     * @param cours
     * @return
     */
    Cours obtenirCoursById(Cours cours) throws CoursInconnuException;

    /**
     * Supprime un cours du système
     * @param cours
     */
    void supprimerCours(Cours cours) throws CoursInconnuException;

    /**
     * Supprime tous les cours du système
     */
    void supprimeTousLesCours();

    /**
     * Retourne tous les cours selon un identifiant de niveau
     * @param idNiveau
     * @return
     */
    Iterable<Cours> obtenirCoursSelonNiveau(int idNiveau);

    /**
     * Retourne tous les créneaux des enseignants par cours dispensés
     * @param idEnseignant
     * @return
     */
    Iterable<Cours> obtenirCreneauxEnseignant(int idEnseignant);

    /**
     * Retourne tous les créneaux auxquels participes / est inscrit l'élève
     * @param idEleve
     * @return
     */
    Iterable<Cours> obtenirCreneauxEleves(int idEleve);
}
