package com.miage.odoru.projet.odorucompetitionservice.clients;

import com.miage.odoru.projet.odorucompetitionservice.definitions.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface qui permet d'interagir avec le service Utilisateur
 */
@FeignClient(name = "odoruUtilisateurService")
public interface OdoroUtilisateurServiceClient {
    /**
     * Retrouve un utilisateur selon son identifiant
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    Utilisateur getUtilisateur(@PathVariable("id") Long id);

    /**
     * Retrouve tous les utilisateurs selon leur niveau
     * @param idNiveau
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    Iterable<Utilisateur> getUtilisateurByIdNiveau(@RequestParam("idNiveau") int idNiveau);
}