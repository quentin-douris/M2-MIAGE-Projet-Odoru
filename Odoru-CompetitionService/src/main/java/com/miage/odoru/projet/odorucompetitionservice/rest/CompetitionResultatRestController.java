package com.miage.odoru.projet.odorucompetitionservice.rest;

import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionNiveau;
import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionResultat;
import com.miage.odoru.projet.odorucompetitionservice.services.CompetitionResultatService;
import com.miage.odoru.projet.odorucompetitionservice.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/competitionresultat")
public class CompetitionResultatRestController {

    @Autowired
    CompetitionResultatService competitionResultatService;
    /**
     * Permet d'obtenir l'ensemble des résultats aux compétitions pour un utilisateur
     * @param idParticipant
     * @return
     */
    @GetMapping("/{idparticipant}")
    public Iterable<CompetitionResultat> getResultatsCompetitionsUtilisateur(@PathVariable("idparticipant") Optional<Integer> idParticipant) {
        return this.competitionResultatService.obtenirResultatsCompetition(idParticipant.get());
    }
}
