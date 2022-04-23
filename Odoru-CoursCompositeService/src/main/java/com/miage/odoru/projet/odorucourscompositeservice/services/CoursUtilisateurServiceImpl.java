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

    /**
     * Retourne tous les cours détaillés selon un identifiant de niveau
     * @param idNiveau
     * @return
     */
    @Override
    public Iterable<CoursTransient> obtenirCoursDetailSelonNiveau(int idNiveau) {
        return this.coursUtilisateurRepository.getAllCoursDetailByIdNiveau(idNiveau);
    }

    /**
     * Retourne tous les cours avec les créneaux d'un enseignant
     * @param idEnseignant
     * @return
     */
    @Override
    public Iterable<CoursTransient> obtenirCreneauxDetailEnseignant(int idEnseignant) {
        return this.coursUtilisateurRepository.getAllCreneauDetailByIdEnseignant(idEnseignant);
    }
}
