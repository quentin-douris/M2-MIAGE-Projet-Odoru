package com.miage.odoru.projet.odoruutilisateurservice.rest;

import com.miage.odoru.projet.odoruutilisateurservice.entities.Utilisateur;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.LoginExistantException;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.NiveauIncorrectException;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.TypeIncorrectException;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.UtilisateurInconnuException;
import com.miage.odoru.projet.odoruutilisateurservice.services.UtilisateurService;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UtilisateurRestController {
    Logger logger = LoggerFactory.getLogger(UtilisateurRestController.class);

    @Autowired
    UtilisateurService utilisateurService;

    /**
     * Permet de créer un utilisateur
     * @param utilisateur
     * @return
     */
    @PostMapping
    public Utilisateur postOne(@RequestBody Utilisateur utilisateur) throws LoginExistantException {
        // Vérification que le login n'est pas déjà utilisé
        Utilisateur utilisateurAvecMemeLogin = this.utilisateurService.obtenirUtilisateurSelonLogin(utilisateur.getLogin());
        if (utilisateurAvecMemeLogin != null) {
            throw new LoginExistantException(utilisateur.getLogin());
        }
        // Création de l'utilisateur
        this.logger.info("Utilisateur : ajouter un nouvel utilisateur dans le système.");
        return this.utilisateurService.creerUtilisateur(utilisateur);
    }

    /**
     * Retourne tous les utilisateurs enregistrés dans le système
     * @param idNiveau
     * @param idType
     * @return
     */
    @GetMapping
    public Iterable<Utilisateur> getAll(@RequestParam("idNiveau") Optional<Integer> idNiveau, @RequestParam("idType") Optional<Integer> idType) {
        // Retourner les utilisateurs selon leur niveau
        if (idNiveau.isPresent()) {
            this.logger.info("Utilisateur : demande la liste de tous les utilisateur selon le niveau : " + idNiveau);
            return this.utilisateurService.obtenirLesMembresSelonNiveau(idNiveau.get());
        }
        // Retourner les utilisateurs selon leur type
        if (idType.isPresent()) {
            this.logger.info("Utilisateur : demande la liste de tous les utilisateur selon leur type : " + idType);
            return this.utilisateurService.obtenirLesMembresSelonType(idType.get());
        }

        // Retourne tous les utilisateurs sans filtre particulier
        this.logger.info("Utilisateur : demande la liste de tous les utilisateur");
        return this.utilisateurService.obtenirLesMembres();
    }

    /**
     * Retourne un utilisateur du système selon son identifiant
     * @param optionalUtilisateur
     * @param idUtilisateur
     * @return
     * @throws UtilisateurInconnuException
     */
    @GetMapping("/{id}")
    public Utilisateur getOne(@PathVariable("id") Optional<Utilisateur> optionalUtilisateur, @PathVariable("id") Long idUtilisateur) throws UtilisateurInconnuException {
        // Vérifie l'existance de l'utilisateur
        if (optionalUtilisateur.isEmpty()) {
            throw new UtilisateurInconnuException(idUtilisateur);
        }
        // Retourne l'utilisateur trouvé
        this.logger.info("Utilisateur : utilisateur avec l'identifiant " + idUtilisateur + "trouvé");
        return this.utilisateurService.obtenirUnUtilisateur(idUtilisateur);
    }

    /**
     * Permet de mettre à jour un utilisateur
     * @param utilisateur
     * @param optionalUtilisateur
     * @param idUtilisateur
     * @return
     * @throws UtilisateurInconnuException
     */
    @PutMapping("/{id}")
    public Utilisateur putOne(@RequestBody Utilisateur utilisateur, @PathVariable("id") Optional<Utilisateur> optionalUtilisateur, @PathVariable("id") Long idUtilisateur)
            throws UtilisateurInconnuException, TypeIncorrectException, NiveauIncorrectException {
        // Vérifie l'existance de l'utilisateur
        if (optionalUtilisateur.isEmpty()) {
            throw new UtilisateurInconnuException(idUtilisateur);
        }
        // Mise à jour de l'utilisateur
        this.logger.info("Utilisateur : mise à jour de l'utilisateur " + idUtilisateur );
        return this.utilisateurService.mettreAJourUtilisateur(idUtilisateur, utilisateur);
    }
}
