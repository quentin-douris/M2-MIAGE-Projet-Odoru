package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service qui s'occupe de la gestion des Créneaux
 */
@Service
public class CreneauServiceImpl implements CreneauService {

    @Autowired
    CoursRepository coursRepository;

    /**
     * Ajoute un nouveau créneau à un cours dans le système
     * @param cours
     * @param creneau
     * @return
     * @throws CoursInconnuException
     */
    @Override
    public Cours ajouterCreneauCours(Cours cours, Creneau creneau) throws CoursInconnuException {
        // Recherche le cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());

        // Si le cours n'est pas trouvé dans le système
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }

        // Ajoute le créneau au cours
        int crenauxSize = optionalCours.get().getCreneaux().size();
        if(crenauxSize > 0) {
            // Incrémente l'id
            long newCreneauId = optionalCours.get().getCreneaux().get(crenauxSize - 1).getId() + 1;
            creneau.setId(newCreneauId);
        } else {
            long creneauId = 1;
            creneau.setId(creneauId);
        }

        // Ajoute le nouveau créneau au cours
        cours.getCreneaux().add(creneau);

        // Sauvegarde le cours dans le système
        return this.coursRepository.save(cours);
    }
}
