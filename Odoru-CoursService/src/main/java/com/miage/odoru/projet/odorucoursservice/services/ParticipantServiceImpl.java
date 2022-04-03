package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.entities.Participant;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.CreneauInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.ParticipantDejaInscritException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Optional;

/**
 * Service qui s'occupe de la gestion des Participants
 */
@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    CoursRepository coursRepository;

    /**
     * Ajoute un participant à un cours sur un créneau spécifique
     * @param cours
     * @param idCreneau
     * @param participant
     * @return
     */
    @Override
    public Cours ajouterParticipantCours(Cours cours, Long idCreneau, Participant participant) throws CoursInconnuException, CreneauInconnuException, ParticipantDejaInscritException {
        // Vérification des données qui concerne les propriétés d'un cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());
        if (optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }

        // Recherche le créneau pour le cours
        Cours resultCreneau = mongoOperations.query(Cours.class)
                .matching(query(where("id").is(cours.getId()).and("creneaux.id").is(idCreneau)))
                .firstValue();

        if (resultCreneau == null) {
            throw new CreneauInconnuException(cours.getId(), idCreneau);
        }

        // Recherche si le participant est déjà inscrit
        Cours resultParticipant = mongoOperations.query(Cours.class)
                .matching(query(where("id").is(cours.getId()).and("creneaux.id").is(idCreneau).and("creneaux.participants.idEleve").is(participant.getIdEleve())))
                .firstValue();

        if(resultParticipant != null) {
            throw new ParticipantDejaInscritException(cours.getId(), idCreneau, participant.getIdEleve());
        }

        // Parcours les créneaux pour inscrire le participant sur le bon
        boolean inscrit = false;
        int cptCreneau = 0;
        while (cptCreneau < resultCreneau.getCreneaux().size() && !inscrit) {
            // Recherche le bon créneau
            if(resultCreneau.getCreneaux().get(cptCreneau).getId() == idCreneau) {
                resultCreneau.getCreneaux().get(cptCreneau).getParticipants().add(participant);
                inscrit = true;
            }

            // Passe au créneau suivant
            cptCreneau++;
        }

        return this.coursRepository.save(resultCreneau);
    }

}
