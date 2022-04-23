package com.miage.odoru.projet.odorubadgeservice.exceptions;
// Exception pour signifier que le badge recherché n'existe pas
public class BadgeInconnuException extends Exception {
    public BadgeInconnuException(Long idBadge) { super("Le badge avec l'id " + idBadge + " n'existe pas ");}
}
