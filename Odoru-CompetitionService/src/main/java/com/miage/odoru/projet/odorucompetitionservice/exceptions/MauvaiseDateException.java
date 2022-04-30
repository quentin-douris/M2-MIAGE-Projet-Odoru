package com.miage.odoru.projet.odorucompetitionservice.exceptions;

public class MauvaiseDateException extends Exception {
    public MauvaiseDateException(String date) {
        super("La date " + date + " est inférieure à 7 jours. Veuillez saisir une date supérieure à 7 jours par rapport à aujourd'hui.");
    }
}
