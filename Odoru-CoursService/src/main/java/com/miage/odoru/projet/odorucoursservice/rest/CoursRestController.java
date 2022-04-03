package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.services.CoursService;
import com.miage.odoru.projet.odorucoursservice.services.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Cours> getAll() {
        this.logger.info("Cours : demande la liste de tous les cours.");
        return this.coursService.obtenirCours();
    }

    /**
     * Créer un nouveau cours dans le système
     * @param cours
     * @return
     */
    @PostMapping
    public Cours postOne(@RequestBody Cours cours) {
        this.logger.info("Cours : ajoute un nouveau cours dans le système.");
        cours.setId(sequenceGeneratorService.generateSequence(Cours.SEQUENCE_NAME));
        return this.coursService.ajouterCours(cours);
    }
}
