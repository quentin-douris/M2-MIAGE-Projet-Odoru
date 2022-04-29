package com.miage.odoru.projet.odorucompetitionservice.rest;

import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionNiveau;
import com.miage.odoru.projet.odorucompetitionservice.definitions.CompetitionResultat;
import com.miage.odoru.projet.odorucompetitionservice.entities.Competition;
import com.miage.odoru.projet.odorucompetitionservice.services.CompetitionNiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/competitionniveau")
public class CompetitionNiveauRestController {

    @Autowired
    CompetitionNiveauService competitionNiveauService;

    @GetMapping("/{idniveau}")
    public CompetitionNiveau getCompetitionsParNiveau(@PathVariable("idniveau") Optional<Integer> idNiveau) {
        return this.competitionNiveauService.getCompetitionNiveauStats(idNiveau.get());
    }
}
