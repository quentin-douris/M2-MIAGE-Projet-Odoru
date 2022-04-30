package com.miage.odoru.projet.odorucompetitionservice.services;

/**
 * Interface du service qui s'occupe de généré un identifiant auto-incrément pour la base de données NoSQL
 */
public interface SequenceGeneratorService {

    /**
     * Méthode permettant de générer une séquence pour gérer les id
     * @param seqName
     * @return
     */
    Long generateSequence(String seqName);
}
