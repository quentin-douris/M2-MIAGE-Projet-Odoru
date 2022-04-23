package com.miage.odoru.projet.odorubadgeservice.services;

import com.miage.odoru.projet.odorubadgeservice.entities.Badge;

/**
 * Interface du service qui s'occupe de la gestion des badges
 */
public interface BadgeService {

    /**
     * Ajouter un nouveau badge dans le système
     * @param badge
     * @return
     */
    Badge creerBadge(Badge badge);

    /**
     * Obtenir un badge selon son identifiant
     * @param idBadge
     * @return
     */
    Badge obtenirBadge(Long idBadge);

    /**
     * Obtenir un badge selon un identifiant d'utilisateur associé
     * @param idUtilisateur
     * @return
     */
    Badge obtenirBadgeSelonUtilisateur(Long idUtilisateur);

    /**
     * Supprimer un badge
     * @param badge
     */
    void supprimerBadge(Badge badge);
}
