package com.miage.odoru.projet.odorustatistiqueservice.rest;

import com.miage.odoru.projet.odorustatistiqueservice.repositories.CompetitionStatistiqueRepository;
import com.miage.odoru.projet.odorustatistiqueservice.services.CompetitionStatistiqueService;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.CompetitionResultatTransient;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCompetitionNiveau;
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
@RequestMapping("/competition")
public class CompetitionStatistiqueRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CompetitionStatistiqueService competitionStatistiqueService;

    /**
     * Calcul le nombre de compétition selon le niveau
     * @param idNiveau
     * @return
     * @throws FeignException
     */
    @GetMapping("/niveau/{idniveau}")
    public StatistiqueCompetitionNiveau getNbCompetitionPourNiveau(@PathVariable("idniveau") Long idNiveau) throws FeignException {
        // Retourne le nombre de compétition selon le niveau
        this.logger.info("Statistique : demande le nombre de compétition selon le niveau.");
        return this.competitionStatistiqueService.obtenirStatistiqueNbCompetitionPourNiveau(idNiveau);
    }

    /**
     * Calcul le résultat d'un élève pour chacune des compétitions à laquelle il a participé
     * @param idEleve
     * @return
     * @throws FeignException
     */
    @GetMapping("/eleve/{ideleve}")
    public Iterable<CompetitionResultatTransient> getCompetitionResultatPourEleve(@PathVariable("ideleve") Long idEleve) throws FeignException {
        // Retourne le résultat aux compétions
        this.logger.info("Statistique : demande le nombre résultat obtenu pour l'élè à chacune des compétitions.");
        return this.competitionStatistiqueService.obtenirStatistiqueCompetitionAvecResultatPourEleve(idEleve);
    }
}
