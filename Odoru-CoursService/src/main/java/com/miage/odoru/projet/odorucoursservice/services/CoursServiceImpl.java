package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Service qui s'occupe de la gestion des Cours
 */
@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    MongoOperations mongoOperations;

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

    /**
     * Supprime un cours du système
     * @param cours
     */
    @Override
    public void supprimerCours(Cours cours) throws CoursInconnuException {
        // Recherche le cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }
        this.coursRepository.delete(cours);
    }

    /**
     * Supprime tous les cours du système
     */
    @Override
    public void supprimeTousLesCours() {
        this.coursRepository.deleteAll();
    }

    /**
     * Retourne tous les cours selon un identifiant de niveau
     * @param idNiveau
     * @return
     */
    @Override
    public Iterable<Cours> obtenirCoursSelonNiveau(int idNiveau) {
        // Recherche si le participant est déjà inscrit
        return this.mongoOperations.query(Cours.class)
                .matching(query(where("idNiveau").is(idNiveau)))
                .all();
    }

    /**
     * Retourne tous les créneaux des enseignants par cours dispensés
     * @param idEnseignant
     * @return
     */
    @Override
    public Iterable<Cours> obtenirCreneauxEnseignant(int idEnseignant) {
        // Recherche les cours pour lequels l'enseignant à au moins un créneau
        Iterable<Cours> coursFound = this.mongoOperations.query(Cours.class)
                .matching(query(where("creneaux.idEnseignant").is(idEnseignant)))
                .all();

        // Supprime les créneaux qui ne sont pas ceux de l'enseignant
        for (Iterator<Cours> coursIterator = coursFound.iterator(); coursIterator.hasNext();) {
            Cours cours = coursIterator.next();
            cours.getCreneaux().removeIf(creneau -> creneau.getIdEnseignant() != idEnseignant);
        }

        return coursFound;
    }
}
