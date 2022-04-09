package com.miage.odoru.projet.odoruutilisateurservice.exceptions;
// Exception pour signifier qu'un utilisateur est inconnu
public class UtilisateurInconnuException extends Exception {

    public UtilisateurInconnuException(Long idUtilisateur) {
        super("L'utilisateur demandé avec l'identifiant " + idUtilisateur + " n'est pas enregistré dans le système");
    }
}
