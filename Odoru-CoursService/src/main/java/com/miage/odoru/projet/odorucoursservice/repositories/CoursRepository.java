package com.miage.odoru.projet.odorucoursservice.repositories;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface qui permet de manipuler techniquement l'entité cours
 */
public interface CoursRepository extends MongoRepository<Cours, Long> {
}
