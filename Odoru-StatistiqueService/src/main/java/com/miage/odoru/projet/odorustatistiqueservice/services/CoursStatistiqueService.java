package com.miage.odoru.projet.odorustatistiqueservice.services;

import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursCreneauxPresence;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursEleveTransient;
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

    /**
     * Retourne le nombre d'élève présent à un cours avec la liste détaillée des élèves
     * @param idCours
     * @param idCreneau
     * @return
     */
    StatistiqueCoursEleveTransient obtenirStatNbElevePresents(Long idCours, Long idCreneau);

    /**
     * Retourne la présence d'un élève à tous les cours pour lesquelles il est inscrit
     * @param idEleve
     * @return
     */
    Iterable<StatistiqueCoursCreneauxPresence> obtenirStatPresenceAbsenceEleve(Long idEleve);
}
