package com.miage.odoru.projet.odorucoursservice.clients;

import com.miage.odoru.projet.odorucoursservice.definitions.Badge;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface qui permet d'interagir avec le service Badge
 */
@FeignClient(name = "odoruBadgeService")
public interface OdoruBadgeServiceClient {
    /**
     * Retrouve l'identifiant de l'utilisateur rattaché au badge
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    Badge getIdUtilisateurByIdBadge(@PathVariable("id") Long id);
}
