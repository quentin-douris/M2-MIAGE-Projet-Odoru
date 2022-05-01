package com.miage.odoru.projet.odorucompetitioncompositeservice.rest;

import com.miage.odoru.projet.odorucompetitioncompositeservice.services.CompetitionUtilisateurService;
import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.CompetitionParticipantTransient;
import feign.FeignException;
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
public class CompetitionUtilisateurRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CompetitionUtilisateurService competitionUtilisateurService;

    /**
     * Controller REST des compétitions avec des détails
     * @param idNiveau
     * @param idEnseignant
     * @param idParticipant
     * @return
     */
    @GetMapping
    public Iterable<CompetitionParticipantTransient> getAll(@RequestParam("idniveau") Optional<Integer> idNiveau, @RequestParam("idenseignant") Optional<Integer> idEnseignant,
                                                            @RequestParam("idparticipant") Optional<Integer> idParticipant) throws FeignException {
        // Retourne les competitions selon leur niveau avec leur détail
        if (idNiveau.isPresent()) {
            this.logger.info("CompetitionComposite : demande la liste de toute les compétitions détaillées selon le niveau : " + idNiveau);
            return this.competitionUtilisateurService.obtenirCompetitionDetailSelonNiveau(idNiveau.get());
        }

        // Retourne les competitions d'un enseignant avec leur détail
        if (idEnseignant.isPresent()) {
            this.logger.info("CompetitionComposite : demande la liste de toute les compétitions détaillée pour un enseignant : " + idEnseignant);
            return this.competitionUtilisateurService.obtenirCompetitionDetailEnseignant(idEnseignant.get());
        }

        // Retourne les competitions d'un participant avec leur détail
        if (idParticipant.isPresent()) {
            this.logger.info("CompetitionComposite : demande la liste de toute les compétitions détaillée pour un participant : " + idParticipant);
            return this.competitionUtilisateurService.obtenirCompetitionDetailParticipant(idParticipant.get());
        }

        // Retourne l'ensemble des compétitions
        return this.competitionUtilisateurService.obtenirCompetitionDetail();
    }
}
