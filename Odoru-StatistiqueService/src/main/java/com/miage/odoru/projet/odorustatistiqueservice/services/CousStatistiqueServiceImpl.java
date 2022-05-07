package com.miage.odoru.projet.odorustatistiqueservice.services;

import com.miage.odoru.projet.odorustatistiqueservice.repositories.CoursStatistiqueRepository;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursCreneauxPresence;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursEleveTransient;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des statistiques pour les Cours
 */
@Service
public class CousStatistiqueServiceImpl implements CoursStatistiqueService {

    @Autowired
    CoursStatistiqueRepository coursStatistiqueRepository;

    /**
     * Retourne les statistiques concernant le nombre de cours avec la présence moyenne des participants.
     * @return
     */
    @Override
    public Iterable<StatistiqueCoursPresenceTransient> obtenirStatNbCoursEtNbMoyenElevePrensent() {
        return this.coursStatistiqueRepository.getStatistiqueCoursPresence();
    }

    /**
     * Retourne le nombre d'élève présent à un cours avec la liste détaillée des élèves
     * @param idCours
     * @param idCreneau
     * @return
     */
    @Override
    public StatistiqueCoursEleveTransient obtenirStatNbElevePresents(Long idCours, Long idCreneau) {
        return this.coursStatistiqueRepository.getStatistiqueNbElevesPresent(idCours, idCreneau);
    }

    /**
     * Retourne la présence d'un élève à tous les cours pour lesquelles il est inscrit
     * @param idEleve
     * @return
     */
    @Override
    public Iterable<StatistiqueCoursCreneauxPresence> obtenirStatPresenceAbsenceEleve(Long idEleve) {
        return this.coursStatistiqueRepository.getStatistiquePresenceAbsenceEleve(idEleve);
    }
}
