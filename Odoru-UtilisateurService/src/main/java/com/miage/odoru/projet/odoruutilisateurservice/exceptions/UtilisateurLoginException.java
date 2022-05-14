package com.miage.odoru.projet.odoruutilisateurservice.exceptions;
// Exception pour signifier qu'un utilisateur est inconnu car son login n'a pas été trouvé
public class UtilisateurLoginException extends Exception {

    public UtilisateurLoginException(String loginUtilisateur) {
        super("L'utilisateur demandé avec le login " + loginUtilisateur + " n'est pas enregistré dans le système");
    }
}
