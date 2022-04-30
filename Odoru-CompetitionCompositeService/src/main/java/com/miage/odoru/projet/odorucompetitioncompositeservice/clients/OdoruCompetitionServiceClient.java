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

    /**
     * Retrouve toutes les compétitions enregistrées selon un id niveau dans le service competition
     * @param idNiveau
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Competition> getAllCompetitionsByIdNiveau(@RequestParam("idniveau") int idNiveau);

    /**
     * Retrouve toutes les compétitions enregistrées selon un id enseignant dans le service competition
     * @param idEnseignant
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Competition> getAllCompetitionByIdEnseignant(@RequestParam("idenseignant") int idEnseignant);

    /**
     * Retrouve toutes les compétitions enregistrées selon un id participant dans le service competition
     * @param idParticipant
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Competition> getAllCompetitionByIdParticipant(@RequestParam("idparticipant") int idParticipant);
}
