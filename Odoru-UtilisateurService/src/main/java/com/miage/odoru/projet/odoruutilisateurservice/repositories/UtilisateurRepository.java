package com.miage.odoru.projet.odoruutilisateurservice.repositories;

import com.miage.odoru.projet.odoruutilisateurservice.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface pour gérer la persistance des utilisateurs
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    // Permet d'obtenir les utilisateurs selon leur un niveau
    Iterable<Utilisateur> getUtilisateurByIdNiveau(int idNiveau);

    // Permet d'obtenir les utilisateurs selon leur type
    Iterable<Utilisateur> getUtilisateurByIdType(int idType);

    // Permet d'obtenir un utilisateur selon son id
    Utilisateur getUtilisateurById(Long idUtilisateur);

    // Permet d'obtenir les utilisateurs selon un login
    Utilisateur getUtilisateurByLogin(String login);
}
