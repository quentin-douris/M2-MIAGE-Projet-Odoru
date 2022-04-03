package com.miage.odoru.projet.odorucoursservice.services;

/**
 * Interface du service qui s'occupe de généré un identifiant auto-incrément pour la base de données NoSQL
 */
public interface SequenceGeneratorService {
    /**
     * Génére un identifiant auto-incrément à partir d'une séquence
     * @param seqName
     * @return
     */
    Long generateSequence(String seqName);
}
