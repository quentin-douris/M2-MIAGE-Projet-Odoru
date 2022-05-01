package com.miage.odoru.projet.odorustatistiqueservice.repositories;

import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursEleveTransient;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;
import org.springframework.stereotype.Repository;

/**
 * Interface qui permet de manipuler techniquement nos objets provenant du service Cours
 */
@Repository
public interface CoursStatistiqueRepository {
    /**
     * Calcul le nombre de créneau dispensé pour un cours et la présence moyenne des participants à ce cours sur tous les créneaux.
     * @return
     */
    Iterable<StatistiqueCoursPresenceTransient> getStatistiqueCoursPresence();

    /**
     * Calcul le nombre d'élève inscrit à un créneau de cours et la présence.
     * @param idCours
     * @param idCreneau
     * @return
     */
    StatistiqueCoursEleveTransient getStatistiqueNbElevesPresent(Long idCours, Long idCreneau);
}
