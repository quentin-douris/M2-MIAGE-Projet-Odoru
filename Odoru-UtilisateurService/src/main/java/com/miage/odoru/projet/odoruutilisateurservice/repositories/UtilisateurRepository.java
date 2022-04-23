package com.miage.odoru.projet.odoruutilisateurservice.repositories;

import com.miage.odoru.projet.odoruutilisateurservice.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface pour gérer la persistance des utilisateurs
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    /**
     * Permet d'obtenir les utilisateurs selon leur un niveau
     * @param idNiveau
     * @return
     */
    Iterable<Utilisateur> getUtilisateurByIdNiveau(int idNiveau);

    /**
     * Permet d'obtenir les utilisateurs selon leur type
     * @param idType
     * @return
     */
    Iterable<Utilisateur> getUtilisateurByIdType(int idType);

    /**
     * Permet d'obtenir un utilisateur selon son id
     * @param idUtilisateur
     * @return
     */
    Utilisateur getUtilisateurById(Long idUtilisateur);

    /**
     * Permet d'obtenir les utilisateurs selon un login
     * @param login
     * @return
     */
    Utilisateur getUtilisateurByLogin(String login);
}
