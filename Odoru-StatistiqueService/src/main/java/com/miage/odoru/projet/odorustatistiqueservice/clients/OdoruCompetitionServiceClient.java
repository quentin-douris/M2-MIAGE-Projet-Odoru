package com.miage.odoru.projet.odorustatistiqueservice.clients;

import com.miage.odoru.projet.odorustatistiqueservice.definitons.Competition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Interface qui permet d'interagir avec le service Competition
 */
@FeignClient(name = "odoruCompetitionService")
public interface OdoruCompetitionServiceClient {
    /**
     * Retrouve toutes les compétitions d'un niveau
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Competition> getCompetitionByIdNiveau(@RequestParam("idniveau") Long idNiveau);
}
