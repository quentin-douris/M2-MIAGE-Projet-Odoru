package com.miage.odoru.projet.odorucompetitionservice.exceptions;

public class EnseignantMauvaisNiveauException extends Exception {
    public EnseignantMauvaisNiveauException(long idEnseignant) {
        super("L'enseignant " + idEnseignant + " ne peut pas créer cette competition car son niveau ne correspond pas");
    }
}
