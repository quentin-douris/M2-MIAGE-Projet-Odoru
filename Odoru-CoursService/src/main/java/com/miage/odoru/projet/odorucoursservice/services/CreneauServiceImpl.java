package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.PlanificationCreneauException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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
     * @throws PlanificationCreneauException
     */
    @Override
    public Cours ajouterCreneauCours(Cours cours, Creneau creneau) throws CoursInconnuException, PlanificationCreneauException {
        // Recherche le cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());

        // Si le cours n'est pas trouvé dans le système
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }

        // Vérifie que la date du créneau respect bien les 7jours entre la date de saisie et la date du créneau
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreneau, today = null;
        try {
            dateCreneau = sdf.parse(creneau.getDate());
            today = new Date(System.currentTimeMillis());
        } catch(Exception ex) {
            throw new PlanificationCreneauException();
        }

        // Vérifie la contrainte de 7 jours de décalage
        long difference = ChronoUnit.DAYS.between(today.toInstant(), dateCreneau.toInstant());
        if(difference < 6) {
            throw new PlanificationCreneauException();
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
