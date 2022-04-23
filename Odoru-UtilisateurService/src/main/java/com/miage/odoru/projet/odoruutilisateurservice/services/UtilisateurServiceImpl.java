package com.miage.odoru.projet.odoruutilisateurservice.services;

import com.miage.odoru.projet.odoruutilisateurservice.entities.Utilisateur;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.NiveauIncorrectException;
import com.miage.odoru.projet.odoruutilisateurservice.exceptions.TypeIncorrectException;
import com.miage.odoru.projet.odoruutilisateurservice.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des utilisateurs
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    /**
     * Créer un nouvel utilisateur dans le système
     * @param utilisateur
     * @return
     */
    @Override
    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        // Type d'utilisateur par défaut à l'inscription : membre
        utilisateur.setIdType(1);
        // Niveau utilisateur par défaut à l'inscription : débutant
        utilisateur.setIdNiveau(1);
        // Inscription non validée par défaut, il faut valider l'inscription par une MAJ via IHM...
        utilisateur.setInscrit(false);
        // Création de l'utilisateur
        return this.utilisateurRepository.save(utilisateur);
    }

    /**
     * Obtenir les utilisateurs du système
     * @return
     */
    @Override
    public Iterable<Utilisateur> obtenirLesMembres() {
        return this.utilisateurRepository.findAll();
    }

    /**
     * Obtenir les utilisateurs du système selon leur niveau
     * @param idNiveau
     * @return
     */
    @Override
    public Iterable<Utilisateur> obtenirLesMembresSelonNiveau(int idNiveau) {
        return this.utilisateurRepository.getUtilisateurByIdNiveau(idNiveau);
    }

    /**
     * Obtenir les utilisateurs du système selon leur type (membre, enseignant, secretaire, president...)
     * @param idType
     * @return
     */
    @Override
    public Iterable<Utilisateur> obtenirLesMembresSelonType(int idType) {
        return this.utilisateurRepository.getUtilisateurByIdType(idType);
    }

    /**
     * Obtenir un utilisateur du système selon son login
     * @param login
     * @return
     */
    @Override
    public Utilisateur obtenirUtilisateurSelonLogin(String login) {
        return this.utilisateurRepository.getUtilisateurByLogin(login);
    }

    /**
     * Obtenir un utilisateur selon son id
     * @param idUtilisateur
     * @return
     */
    @Override
    public Utilisateur obtenirUnUtilisateur(Long idUtilisateur) {
        return this.utilisateurRepository.getUtilisateurById(idUtilisateur);
    }

    /**
     * Permet de mettre à jour un utilisateur
     * @param idUtilisateur
     * @param utilisateurAJour
     * @return
     */
    @Override
    public Utilisateur mettreAJourUtilisateur(Long idUtilisateur, Utilisateur utilisateurAJour) throws NiveauIncorrectException, TypeIncorrectException {
        Utilisateur utilisateurAModifier = this.utilisateurRepository.getUtilisateurById(idUtilisateur);
        if (utilisateurAJour.getNom() != null) {
            utilisateurAModifier.setNom(utilisateurAJour.getNom());
        }
        if (utilisateurAJour.getPrenom() != null) {
            utilisateurAModifier.setPrenom(utilisateurAJour.getPrenom());
        }
        if (utilisateurAJour.getMail() != null) {
            utilisateurAModifier.setMail(utilisateurAJour.getMail());
        }
        if (utilisateurAJour.getLogin() != null) {
            utilisateurAModifier.setLogin(utilisateurAJour.getLogin());
        }
        if (utilisateurAJour.getPassword() != null) {
            utilisateurAModifier.setPassword(utilisateurAJour.getPassword());
        }
        if (utilisateurAJour.getVille() != null) {
            utilisateurAModifier.setVille(utilisateurAJour.getVille());
        }
        if (utilisateurAJour.getPays() != null) {
            utilisateurAModifier.setPays(utilisateurAJour.getPays());
        }
        if (utilisateurAJour.getIdNiveau() != 0) {
            if (utilisateurAJour.getIdNiveau() > 3) {
                throw new NiveauIncorrectException(utilisateurAJour.getIdNiveau());
            }
            utilisateurAModifier.setIdNiveau(utilisateurAJour.getIdNiveau());
        }
        if (utilisateurAJour.getIdType() != 0) {
            if (utilisateurAJour.getIdType() > 4) {
                throw new TypeIncorrectException(utilisateurAJour.getIdType());
            }
            utilisateurAModifier.setIdType(utilisateurAJour.getIdType());
        }
        if (utilisateurAJour.isInscrit()) {
            utilisateurAModifier.setInscrit(utilisateurAJour.isInscrit());
        }
        return this.utilisateurRepository.save(utilisateurAModifier);
    }

}
