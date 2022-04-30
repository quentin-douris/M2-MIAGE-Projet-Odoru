package com.miage.odoru.projet.odorustatistiqueservice.clients;

import com.miage.odoru.projet.odorustatistiqueservice.definitons.Cours;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
