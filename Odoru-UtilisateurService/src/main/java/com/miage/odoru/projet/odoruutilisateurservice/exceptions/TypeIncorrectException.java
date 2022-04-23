package com.miage.odoru.projet.odoruutilisateurservice.exceptions;
// Exception pour signifier qu'un type d'utilisateur est incorrect

/**
 * Rappel :
 * 1 : Membre
 * 2 : Secretaire
 * 3 : Enseignant
 * 4 : President
 */
public class TypeIncorrectException extends Exception {
    public TypeIncorrectException(int idType) {
        super("Le type avec l'identifiant " + idType + " n'existe pas");
    }
}
