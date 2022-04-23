package com.miage.odoru.projet.odorucourscompositeservice.rest;

import com.miage.odoru.projet.odorucourscompositeservice.services.CoursUtilisateurService;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.CoursTransient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class CoursUtilisateurRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CoursUtilisateurService coursUtilisateurService;

    /**
     * Retourne tous les cours avec leur détail enregistré dans le système
     * @param idNiveau
     * @param idEnseignant
     * @return
     */
    @GetMapping
    public Iterable<CoursTransient> getAll(@RequestParam("idniveau") Optional<Integer> idNiveau, @RequestParam("idenseignant") Optional<Integer> idEnseignant) {
        // Retourne les cours selon leur niveau avec leur détail

        // Retourne les cours d'un enseignant avec leur détail

        // Retourne tous les cours enregistrés dans le système avec leur détail
        this.logger.info("Cours : demande la liste de tous les cours.");
        return this.coursUtilisateurService.obtenirCoursDetail();
    }

}
