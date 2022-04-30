package com.miage.odoru.projet.odorucompetitioncompositeservice.clients;

import com.miage.odoru.projet.odorucompetitioncompositeservice.definitions.Competition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Interface qui permet d'intéragir avec le service Competition
 */
@FeignClient(name = "odoruCompetitionService")
public interface OdoruCompetitionServiceClient {
    /**
     * Retrouve toutes les competitions enregistrées dans le service competition
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Competition> getAllCompetition();

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Competition> getAllCompetitionsByIdNiveau(@RequestParam("idniveau") int idNiveau);
}
