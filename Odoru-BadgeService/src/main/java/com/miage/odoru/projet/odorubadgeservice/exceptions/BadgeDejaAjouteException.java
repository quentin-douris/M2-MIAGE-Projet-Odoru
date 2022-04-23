package com.miage.odoru.projet.odorubadgeservice.exceptions;
// Exception pour signifier qu'un badge est déjà associé à l'utilisateur
public class BadgeDejaAjouteException extends Exception {
    public BadgeDejaAjouteException(Long idUtilisateur) { super("L'utilisateur avec l'id " + idUtilisateur + " possède déjà un badge !"); }
}
