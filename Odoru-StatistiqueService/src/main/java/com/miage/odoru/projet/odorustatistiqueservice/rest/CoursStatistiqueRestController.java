package com.miage.odoru.projet.odorustatistiqueservice.rest;

import com.miage.odoru.projet.odorustatistiqueservice.services.CoursStatistiqueService;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursCreneauxPresence;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursEleveTransient;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cours")
public class CoursStatistiqueRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CoursStatistiqueService coursStatistiqueService;

    /**
     * Calcul le nombre de cours avec la présence moyenne des participants
     * @return
     * @throws FeignException
     */
    @GetMapping("/presence")
    public Iterable<StatistiqueCoursPresenceTransient> getCoursPresence() throws FeignException {
        // Retourne la statistique de présence pour le cours
        this.logger.info("Statistique : demande le nombre de cours avec la présence moyenne des participants.");
        return this.coursStatistiqueService.obtenirStatNbCoursEtNbMoyenElevePrensent();
    }

    /**
     * Calcul le nombre de participant sur un créneau de cours avec la liste des participants
     * @param idCours
     * @param idCreneau
     * @return
     * @throws FeignException
     */
    @GetMapping("/{idcours}/creneau/{idcreneau}/presence")
    public StatistiqueCoursEleveTransient getCoursCreneauPresence(@PathVariable("idcours") Long idCours, @PathVariable("idcreneau") Long idCreneau) throws FeignException {
        // Retourne la statistique de présence pour le cours
        this.logger.info("Statistique : demande le nombre de participant sur un créneau de cours avec la liste des participants.");
        return this.coursStatistiqueService.obtenirStatNbElevePresents(idCours, idCreneau);
    }

    /**
     * Calcul la statistique de présence pour les créneaux de cours d'un élève
     * @return
     * @throws FeignException
     */
    @GetMapping("/eleve/{ideleve}")
    public Iterable<StatistiqueCoursCreneauxPresence> getCoursCreneauElevePresence(@PathVariable("ideleve") Long idEleve) throws FeignException {
        // Retourne la statistique de présence pour les créneaux de cours d'un élève
        this.logger.info("Statistique : demande la statistique de présence pour les créneaux de cours d'un élève.");
        return this.coursStatistiqueService.obtenirStatPresenceAbsenceEleve(idEleve);
    }
}
