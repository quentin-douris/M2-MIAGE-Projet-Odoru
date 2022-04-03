package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    CoursRepository coursRepository;

    /**
     * Créer un nouveau cours dans le système
     * @param cours
     * @return
     */
    @Override
    public Cours ajouterCours(Cours cours) {
        return this.coursRepository.save(cours);
    }

    /**
     * Retourne tous les cours enregistrés dans le système
     * @return
     */
    @Override
    public Iterable<Cours> obtenirCours() {
        return this.coursRepository.findAll();
    }

}
