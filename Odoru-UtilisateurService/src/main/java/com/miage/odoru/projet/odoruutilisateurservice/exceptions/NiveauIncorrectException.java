package com.miage.odoru.projet.odoruutilisateurservice.exceptions;
// Exception pour signifier qu'un niveau est incorrect

/**
 * Rappel :
 * 1 : Débutant
 * 2 : Moyen
 * 3 : Expert
 */
public class NiveauIncorrectException extends Exception {
    public NiveauIncorrectException(int idNiveau) {
        super("Le niveau avec l'identifiant " + idNiveau + " n'existe pas");
    }
}
