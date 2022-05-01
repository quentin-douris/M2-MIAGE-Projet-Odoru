package com.miage.odoru.projet.odorustatistiqueservice.clients;

import com.miage.odoru.projet.odorustatistiqueservice.definitons.Cours;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
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
     * Retrouve un cours selon son identifiant enregistré dans le service cours
     * @param idCours
     * @param idCreneau
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{idcours}/creneau/{idcreneau}", produces = "application/json")
    Cours getOne(@PathVariable("idcours") Long idCours, @PathVariable("idcreneau") Long idCreneau);

    /**
     * Retrouve tous les créneaux de cours auxquels participe un élève
     * @param idEleve
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    Iterable<Cours> getCoursByIdEleve(@RequestParam("ideleve") Long idEleve);
}
