package com.miage.odoru.projet.odorustatistiqueservice.services;

import com.miage.odoru.projet.odorustatistiqueservice.repositories.CoursStatistiqueRepository;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des statistique pour les Cours
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
}
