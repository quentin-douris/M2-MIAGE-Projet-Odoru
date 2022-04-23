package com.miage.odoru.projet.odorucourscompositeservice.clients;

import com.miage.odoru.projet.odorucourscompositeservice.definitions.Cours;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Interface qui permet d'interagir avec le service Cours
 */
@FeignClient(name = "odoruCoursService")
public interface OdoruCoursServiceClient {
    /**
     * Retrouve tous les cours enregistrés dans le service cours
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Cours> getAllCours();

    /**
     * Retrouve tous les cours enregistrés dans le service cours selon leur idNiveau
     * @param idNiveau
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Cours> getAllCoursByIdNiveau(@RequestParam("idniveau") int idNiveau);

    /**
     * Retrouve tous les créneaux de cours enregistrés dans le service cours selon leur idEnseignant
     * @param idEnseignant
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    List<Cours> getAllCreneauxCoursByIdEnseignant(@RequestParam("idenseignant") int idEnseignant);

}
