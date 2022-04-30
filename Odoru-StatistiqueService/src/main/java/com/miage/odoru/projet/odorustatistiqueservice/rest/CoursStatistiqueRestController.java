package com.miage.odoru.projet.odorustatistiqueservice.rest;

import com.miage.odoru.projet.odorustatistiqueservice.services.CoursStatistiqueService;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CoursStatistiqueRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CoursStatistiqueService coursStatistiqueService;

    @GetMapping("cours/presence")
    public Iterable<StatistiqueCoursPresenceTransient> getCoursPresence() {
        // Retourne la statistique de présence pour le cours
        this.logger.info("Statistique : demande le nombre de cours avec la présence moyenne des participants.");
        return this.coursStatistiqueService.obtenirStatNbCoursEtNbMoyenElevePrensent();
    }
}
