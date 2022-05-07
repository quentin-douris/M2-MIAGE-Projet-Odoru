package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.entities.Participant;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
     * Retourne un cours selon son identifiant
     * @param cours
     * @return
     */
    @Override
    public Cours obtenirCoursById(Cours cours) throws CoursInconnuException {
        // Recherche le cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }
        return optionalCours.get();
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

    /**
     * Retourne tous les créneaux auxquels participes / est inscrit l'élève
     * @param idEleve
     * @return
     */
    @Override
    public Iterable<Cours> obtenirCreneauxEleves(int idEleve) {
        // Recherche les cours pour lesquels l'élève participe à au moins un créneau
        Iterable<Cours> coursFound = this.mongoOperations.query(Cours.class)
                .matching(query(where("creneaux.participants.idEleve").is(idEleve)))
                .all();

        // Liste qui sera retournée avec le résultat
        List<Cours> coursList = new ArrayList<>();

        // Construit les objets cours à retourner
        for (Cours cours : coursFound) {
            Cours coursTransient = new Cours();
            coursTransient.setId(cours.getId());
            coursTransient.setTitre(cours.getTitre());
            coursTransient.setIdNiveau(cours.getIdNiveau());
            coursTransient.setCreneaux(new ArrayList<>());

            for (Creneau creneau : cours.getCreneaux()) {
                for(Participant participant : creneau.getParticipants()) {
                    if(participant.getIdEleve() == idEleve) {
                        // On ajoute le créneau à la liste de retour
                        Creneau creneauTransient = new Creneau();
                        creneauTransient.setId(creneau.getId());
                        creneauTransient.setDate(creneau.getDate());
                        creneauTransient.setDuree(creneau.getDuree());
                        creneauTransient.setIdEnseignant(creneau.getIdEnseignant());
                        creneauTransient.setNumSalle(creneau.getNumSalle());
                        coursTransient.getCreneaux().add(creneauTransient);
                    }
                }
            }

            coursList.add(coursTransient);
        }

        return coursList;
    }
}
