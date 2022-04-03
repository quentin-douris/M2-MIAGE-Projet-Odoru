package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;

public interface CreneauService {
    /**
     * Ajoute un nouveau créneau à un cours dans le système
     * @param cours
     * @param creneau
     * @return
     */
    Cours ajouterCreneauCours(Cours cours, Creneau creneau) throws CoursInconnuException;
}