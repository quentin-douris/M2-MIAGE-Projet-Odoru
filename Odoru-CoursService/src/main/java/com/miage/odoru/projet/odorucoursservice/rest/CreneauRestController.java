package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.EnseignantInapteException;
import com.miage.odoru.projet.odorucoursservice.exceptions.PlanificationCreneauException;
import com.miage.odoru.projet.odorucoursservice.services.CreneauService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/{idcours}/creneau")
public class CreneauRestController {

    Logger logger = LoggerFactory.getLogger(CreneauRestController.class);

    @Autowired
    CreneauService creneauService;

    /**
     * Créer un nouveau créneau pour un cours dans le système
     * @param optionalCours
     * @param creneau
     * @return
     */
    @PostMapping
    public Cours postOne(@PathVariable("idcours") Optional<Cours> optionalCours, @PathVariable("idcours") Long idCours, @RequestBody Creneau creneau) throws CoursInconnuException, PlanificationCreneauException, EnseignantInapteException {
        // Vérifie que le cours existe
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(idCours);
        }

        // Ajoute le nouveau creneau dans le système
        this.logger.info("Creneau : ajout d'un nouveau créneau pour le cours id : " + optionalCours.get().getId());
        return this.creneauService.ajouterCreneauCours(optionalCours.get(), creneau);
    }
}
