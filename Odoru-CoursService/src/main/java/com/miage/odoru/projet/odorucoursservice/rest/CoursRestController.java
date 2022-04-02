package com.miage.odoru.projet.odorucoursservice.rest;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CoursRestController {
    @Autowired
    CoursService coursService;

    /**
     * Retourne tous les cours enregistrés dans le système
     * @return
     */
    @GetMapping
    public Iterable<Cours> getAll() {
        return this.coursService.obtenirCours();
    }

    /**
     * Créer un nouveau cours dans le système
     * @param cours
     * @return
     */
    @PostMapping
    public Cours postOne(@RequestBody Cours cours) {
        return this.coursService.ajouterCours(cours);
    }
}
