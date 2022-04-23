package com.miage.odoru.projet.odorucourscompositeservice.services;

import com.miage.odoru.projet.odorucourscompositeservice.repositories.CoursUtilisateurRepository;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.CoursTransient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des Cours avec leur détail
 */
@Service
public class CoursUtilisateurServiceImpl implements CoursUtilisateurService {

    @Autowired
    CoursUtilisateurRepository coursUtilisateurRepository;

    /**
     * Retourne tous les cours détaillés enregistrés dans le système
     * @return
     */
    @Override
    public Iterable<CoursTransient> obtenirCoursDetail() {
        return this.coursUtilisateurRepository.getAllCoursDetail();
    }
}
