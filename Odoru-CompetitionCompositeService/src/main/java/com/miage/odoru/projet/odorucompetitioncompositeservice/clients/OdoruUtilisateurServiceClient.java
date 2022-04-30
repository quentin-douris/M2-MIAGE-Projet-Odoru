package com.miage.odoru.projet.odorucompetitioncompositeservice.clients;

import com.miage.odoru.projet.odorucompetitioncompositeservice.definitions.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface qui permet d'interagir avec le service Utilisateur
 */
@FeignClient(name = "odoruUtilisateurService")
public interface OdoruUtilisateurServiceClient {
    /**
     * Retrouve un utilisateur selon son identifiant
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    Utilisateur getUtilisateur(@PathVariable("id") Long id);
}
