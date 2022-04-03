package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.services.CreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/{idcours}/creneau")
public class CreneauRestController {
    @Autowired
    CreneauService creneauService;

    /**
     * Créer un nouveau créneau pour un cours dans le système
     * @param optionalCours
     * @param creneau
     * @return
     */
    @PostMapping
    public Cours postOne(@PathVariable("idcours") Optional<Cours> optionalCours, @PathVariable("idcours") Long idCours, @RequestBody Creneau creneau) throws CoursInconnuException {
        // Si le cours n'existe pas dans le système
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(idCours);
        }

        // Ajoute le nouveau creneau dans le système
        return this.creneauService.ajouterCreneauCours(optionalCours.get(), creneau);
    }
}
