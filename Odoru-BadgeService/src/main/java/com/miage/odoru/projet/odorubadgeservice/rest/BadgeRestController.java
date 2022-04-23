package com.miage.odoru.projet.odorubadgeservice.rest;

import com.miage.odoru.projet.odorubadgeservice.entities.Badge;
import com.miage.odoru.projet.odorubadgeservice.exceptions.BadgeDejaAjouteException;
import com.miage.odoru.projet.odorubadgeservice.exceptions.BadgeInconnuException;
import com.miage.odoru.projet.odorubadgeservice.services.BadgeService;
import com.miage.odoru.projet.odorubadgeservice.services.BadgeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class BadgeRestController {
    Logger logger = LoggerFactory.getLogger(BadgeRestController.class);

    @Autowired
    BadgeService badgeService;

    /**
     * Méthode permettant d'ajouter un badge dans le système
     * @param badge
     * @return
     */
    @PostMapping
    public Badge postOne(@RequestBody Badge badge) throws BadgeDejaAjouteException {
        // Vérification que l'utilisateur n'est pas déjà associé à un badge
        Badge badgeVerif = this.badgeService.obtenirBadgeSelonUtilisateur(badge.getIdUtilisateur());
        if (badgeVerif != null) {
            this.logger.info("Badge : utilisateur déjà associé à un badge.");
            throw new BadgeDejaAjouteException(badgeVerif.getIdUtilisateur());
        }
        // Création du badge
        this.logger.info("Badge : ajouter un nouveau badge dans le système.");
        return this.badgeService.creerBadge(badge);
    }


    /**
     * Méthode permettant d'obtenir un badge du système selon son identifiant de badge
     * @param optionalBadge
     * @param idBadge
     * @return
     * @throws BadgeInconnuException
     */
    @GetMapping("/{id}")
    public Badge getOne(@PathVariable("id") Optional<Badge> optionalBadge, @PathVariable("id") Long idBadge) throws BadgeInconnuException {
        // Vérifie l'existence du badge
        if (optionalBadge.isEmpty()) {
            this.logger.info("Badge : badge inconnu");
            throw new BadgeInconnuException(idBadge);
        }
        // Retourne le badge trouvé
        this.logger.info("Badge : badge avec l'identifiant " + idBadge + " trouvé");
        return this.badgeService.obtenirBadge(idBadge);
    }

    /**
     * Méthode permettant de supprimer un badge du système selon son identifiant de badge
     * @param optionalBadge
     * @param idBadge
     * @throws BadgeInconnuException
     */
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Optional<Badge> optionalBadge, @PathVariable("id") Long idBadge) throws BadgeInconnuException {
        // Vérifie l'existence du badge
        if (optionalBadge.isEmpty()) {
            this.logger.info("Badge : badge inconnu.");
            throw new BadgeInconnuException(idBadge);
        }
        // Suppression du badge
        this.logger.info("Badge : badge avec l'identifiant " + idBadge + " trouvé, suppression effectuée");
        this.badgeService.supprimerBadge(optionalBadge.get());
    }
}
