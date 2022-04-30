package com.miage.odoru.projet.odorustatistiqueservice.services;

import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;

/**
 * Interface du service qui s'occupe de la gestion des statistiques des Cours
 */
public interface CoursStatistiqueService {
    /**
     * Retourne les statistiques concernant le nombre de cours avec la présence moyenne des participants.
     * @return
     */
    Iterable<StatistiqueCoursPresenceTransient> obtenirStatNbCoursEtNbMoyenElevePrensent();
}
