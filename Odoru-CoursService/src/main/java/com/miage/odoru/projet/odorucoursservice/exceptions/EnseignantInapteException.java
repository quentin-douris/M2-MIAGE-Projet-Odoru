package com.miage.odoru.projet.odorucoursservice.exceptions;

/**
 * Exception pour la création d'un cours, l'enseignant doit être suffisament qualifié pour le dispensé
 */
public class EnseignantInapteException extends Exception {
    public EnseignantInapteException(int niveauEnseignant, int niveauCours) {
        super("L'enseignant saisi pour ce cours avec le niveau " + niveauEnseignant + " n'est pas suffisamment qualifié pour un cours de niveau : " + niveauCours);
    }
}
