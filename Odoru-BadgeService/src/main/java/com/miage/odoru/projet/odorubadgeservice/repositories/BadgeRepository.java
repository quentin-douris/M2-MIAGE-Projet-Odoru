package com.miage.odoru.projet.odorubadgeservice.repositories;

import com.miage.odoru.projet.odorubadgeservice.entities.Badge;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface pour gérer la persistence des badges
 */
public interface BadgeRepository extends CrudRepository<Badge, Long> {

    /**
     * Permet d'obtenir un badge stocké en BDD selon son idBadge
     * @param idBadge
     * @return
     */
    Badge getBadgeByIdBadge(Long idBadge);

    /**
     * Permet d'obtenir un badge stocké en BDD selon son id utilisateur associé
     * @param idUtilisateur
     * @return
     */
    Badge getBadgeByIdUtilisateur(Long idUtilisateur);

}
