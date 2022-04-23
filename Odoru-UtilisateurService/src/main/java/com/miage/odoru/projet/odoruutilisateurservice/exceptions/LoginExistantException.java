package com.miage.odoru.projet.odoruutilisateurservice.exceptions;
// Exception pour signifier qu'un login existe déjà en base de données
public class LoginExistantException extends Exception {
    public LoginExistantException(String login) {
        super("L'utilisateur avec le login " + login + " existe déjà !");
    }
}
