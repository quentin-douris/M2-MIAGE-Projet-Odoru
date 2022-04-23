package com.miage.odoru.projet.odoruutilisateurservice.services;

import com.miage.odoru.projet.odoruutilisateurservice.entities.Utilisateur;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.NiveauIncorrectException;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.TypeIncorrectException;
import org.apache.logging.log4j.util.PropertySource;

/**
 * Interface du service qui s'occupe de la gestion des utilisateurs
 */
public interface UtilisateurService {

    /**
     * Ajoute un nouvel utilisateur dans le système
     * @param utilisateur
     * @return
     */
    Utilisateur creerUtilisateur(Utilisateur utilisateur);

    /**
     * Obtenir les utilisateurs du système
     * @return
     */
    Iterable<Utilisateur> obtenirLesMembres();

    /**
     * Obtenir les utilisateurs du système selon leur niveau
     * @param idNiveau
     * @return
     */
    Iterable<Utilisateur> obtenirLesMembresSelonNiveau(int idNiveau);

    /**
     * Obtenir les utilisateurs du système selon leur type
     * @param idType
     * @return
     */
    Iterable<Utilisateur> obtenirLesMembresSelonType(int idType);

    /**
     * Obtenir les utilisateurs du système selon leur login
     * @param login
     * @return
     */
    Utilisateur obtenirUtilisateurSelonLogin(String login);

    /**
     * Obtenir un utilisateur selon son id
     * @param idUtilisateur
     * @return
     */
    Utilisateur obtenirUnUtilisateur(Long idUtilisateur);

    /**
     * Permet de mettre à jour un utilisateur
     * @param idUtilisateur
     * @param utilisateurAJour
     * @return
     */
    Utilisateur mettreAJourUtilisateur(Long idUtilisateur, Utilisateur utilisateurAJour) throws NiveauIncorrectException, TypeIncorrectException;
}
