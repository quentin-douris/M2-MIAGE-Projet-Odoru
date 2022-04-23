package com.miage.odoru.projet.odorubadgeservice.services;

import com.miage.odoru.projet.odorubadgeservice.entities.Badge;
import com.miage.odoru.projet.odorubadgeservice.repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des badges
 */
@Service
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    BadgeRepository badgeRepository;

    /**
     * Créer un nouveau badge dans le système
     * @param badge
     * @return
     */
    @Override
    public Badge creerBadge(Badge badge) {
        return this.badgeRepository.save(badge);
    }

    /**
     * Obtenir un badge selon son identifiant
     * @param idBadge
     * @return
     */
    @Override
    public Badge obtenirBadge(Long idBadge) {
        return this.badgeRepository.getBadgeByIdBadge(idBadge);
    }

    /**
     * Obtenir un badge selon un identifiant utilisateur
     * @param idUtilisateur
     * @return
     */
    @Override
    public Badge obtenirBadgeSelonUtilisateur(Long idUtilisateur) {
        return this.badgeRepository.getBadgeByIdUtilisateur(idUtilisateur);
    }

    /**
     * Supprimer un badge
     * @param badge
     */
    @Override
    public void supprimerBadge(Badge badge) {
        this.badgeRepository.delete(badge);
    }


}
