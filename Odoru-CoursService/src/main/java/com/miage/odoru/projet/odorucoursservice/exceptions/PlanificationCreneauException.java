package com.miage.odoru.projet.odorucoursservice.exceptions;

import java.time.LocalDate;

/**
 * Exception pour l'ajout d'un créneau qui ne respecte pas le délai de 7jours par rapport à la date de saisie
 */
public class PlanificationCreneauException extends Exception {
    public PlanificationCreneauException() {
        super("La date saisie du créneau saisie doit être supérieur à 7 jours par rapport à la date du jour : " + LocalDate.now());
    }
}
