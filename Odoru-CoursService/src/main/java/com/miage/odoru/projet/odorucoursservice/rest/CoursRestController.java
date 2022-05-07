package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.services.CoursService;
import com.miage.odoru.projet.odorucoursservice.services.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class CoursRestController {
    Logger logger = LoggerFactory.getLogger(CoursRestController.class);

    @Autowired
    CoursService coursService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    /**
     * Retourne tous les cours enregistrés dans le système
     * @return
     */
    @GetMapping
    public Iterable<Cours> getAll(@RequestParam("idniveau") Optional<Integer> idNiveau, @RequestParam("idenseignant") Optional<Integer> idEnseignant, @RequestParam("ideleve") Optional<Integer> idEleve) {
        // Retourne les cours selon leur niveau
        if(idNiveau.isPresent()) {
            this.logger.info("Cours : demande la liste de tous les cours selon le niveau : " + idNiveau);
            return this.coursService.obtenirCoursSelonNiveau(idNiveau.get());
        }

        // Retourne les cours d'un enseignant
        if(idEnseignant.isPresent()) {
            this.logger.info("Cours : demande la liste de tous les créneaux de cours dispensés par l'enseignant : " + idEnseignant);
            return this.coursService.obtenirCreneauxEnseignant(idEnseignant.get());
        }

        // Retourne les cours d'un élève
        if(idEleve.isPresent()) {
            this.logger.info("Cours : demande la liste de tous les créneaux de cours auxquels participe l'élève : " + idEleve);
            return this.coursService.obtenirCreneauxEleves(idEleve.get());
        }

        // Retourne tous les cours enregistrés dans le système
        this.logger.info("Cours : demande la liste de tous les cours.");
        return this.coursService.obtenirCours();
    }

    /**
     * Retourne un cours selon son identifiant
     * @param optionalCours
     * @return
     */
    @GetMapping("/{id}")
    public Cours getOne(@PathVariable("id") Optional<Cours> optionalCours, @PathVariable("id") Long idCours) throws CoursInconnuException {
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(idCours);
        }

        // Retourne le cours enregistré dans le système
        this.logger.info("Cours : demande le cours avec l'identifiant : " + idCours);
        return this.coursService.obtenirCoursById(optionalCours.get());
    }

    /**
     * Créer un nouveau cours dans le système
     * @param cours
     * @return
     */
    @PostMapping
    public Cours postOne(@RequestBody Cours cours) {
        this.logger.info("Cours : ajoute un nouveau cours dans le système.");
        // Récupère l'identifiant du cours selon la séquence
        cours.setId(sequenceGeneratorService.generateSequence(Cours.SEQUENCE_NAME));
        return this.coursService.ajouterCours(cours);
    }

    /**
     * Supprime un cours dans le système
     * @param optionalCours
     * @param idCours
     * @throws CoursInconnuException
     */
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Optional<Cours> optionalCours, @PathVariable("id") Long idCours) throws CoursInconnuException {
        // Vérifie l'existance du cours
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(idCours);
        }

        // Supprime le cours du système
        this.logger.info("Cours : suppression du cours " + idCours + " du système");
        this.coursService.supprimerCours(optionalCours.get());
    }

    /**
     * Supprime tous les cours dans le système
     */
    @DeleteMapping
    public void deleteAll() {
        // Supprime le cours du système
        this.logger.info("Cours : suppression de tous les cours du système");
        this.coursService.supprimeTousLesCours();
    }
}
