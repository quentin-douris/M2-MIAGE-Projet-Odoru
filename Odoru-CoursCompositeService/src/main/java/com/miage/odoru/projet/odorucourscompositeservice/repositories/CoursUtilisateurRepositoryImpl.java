package com.miage.odoru.projet.odorucourscompositeservice.repositories;

import com.miage.odoru.projet.odorucourscompositeservice.clients.OdoruCoursServiceClient;
import com.miage.odoru.projet.odorucourscompositeservice.clients.OdoruUtilisateurServiceClient;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Cours;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Creneau;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Participant;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Utilisateur;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.*;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe qui permet de manipuler techniquement nos objets provenant des autres services
 */
@NoArgsConstructor
public class CoursUtilisateurRepositoryImpl implements CoursUtilisateurRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OdoruCoursServiceClient odoruCoursServiceClient;

    @Autowired
    private OdoruUtilisateurServiceClient odoruUtilisateurServiceClient;

    /**
     * Recherche tous les cours et les utilisateurs pour construire un cours avec son détail
     * @return
     */
    @Override
    public Iterable<CoursTransient> getAllCoursDetail() {
        this.logger.info("Obtenir tous les cours enregistrés dans le système avec le détail de leurs informations");

        // Récupération de tous les cours auprès du service Cours
        this.logger.info("Demande les cours au service CoursService");
        Iterable<Cours> coursList = this.odoruCoursServiceClient.getAllCours();

        // Variable qui va contenir notre résultat
        List<CoursTransient> result = new ArrayList<>();

        // Construction de l'objet CoursTransient
        this.logger.info("Construction de la liste des CoursTransient.");
        for (Iterator<Cours> coursIterator = coursList.iterator(); coursIterator.hasNext();) {
            Cours cours = coursIterator.next();
            result.add(this.factoryCoursTransient(cours));
        }

        this.logger.info("Construction de la liste des CoursTransient terminée.");
        return result;
    }

    /**
     * Recherche tous les cours selon le niveau et les utilisateurs pour construire un cours avec son détail
     * @param idNiveau
     * @return
     */
    @Override
    public Iterable<CoursTransient> getAllCoursDetailByIdNiveau(int idNiveau) {
        this.logger.info("Obtenir tous les cours enregistrés dans le système selon leur idNiveau avec le détail de leurs informations");

        // Récupération de tous les cours auprès du service Cours
        this.logger.info("Demande les cours selon leur idNiveau au service CoursService");
        Iterable<Cours> coursList = this.odoruCoursServiceClient.getAllCoursByIdNiveau(idNiveau);

        // Variable qui va contenir notre résultat
        List<CoursTransient> result = new ArrayList<>();

        // Construction de l'objet CoursTransient
        this.logger.info("Construction de la liste des CoursTransient.");
        for (Iterator<Cours> coursIterator = coursList.iterator(); coursIterator.hasNext();) {
            Cours cours = coursIterator.next();
            result.add(this.factoryCoursTransient(cours));
        }
        this.logger.info("Construction de la liste des CoursTransient terminée.");
        return result;
    }

    /**
     * Recherche tous les cours avec les créneaux d'un enseignant pour construire un cours avec son détail
     * @param idEnseignant
     * @return
     */
    @Override
    public Iterable<CoursTransient> getAllCreneauDetailByIdEnseignant(int idEnseignant) {
        this.logger.info("Obtenir tous les cours enregistrés avec ses créneaux dans le système pour un enseignant avec le détail des informations du cours.");

        // Récupération de tous les cours auprès du service Cours
        this.logger.info("Demande les créneaux de cours selon idEnseignant au service CoursService");
        Iterable<Cours> coursList = this.odoruCoursServiceClient.getAllCreneauxCoursByIdEnseignant(idEnseignant);

        // Variable qui va contenir notre résultat
        List<CoursTransient> result = new ArrayList<>();

        // Construction de l'objet CoursTransient
        this.logger.info("Construction de la liste des CoursTransient.");
        for (Iterator<Cours> coursIterator = coursList.iterator(); coursIterator.hasNext();) {
            Cours cours = coursIterator.next();
            result.add(this.factoryCoursTransientForEnseignant(cours));
        }
        this.logger.info("Construction de la liste des CoursTransient terminée.");
        return result;
    }

    /**
     * Construit un objet cours transient selon un cours provenant de CoursService
     * @param cours
     * @return
     */
    private CoursTransient factoryCoursTransient(Cours cours) {
        this.logger.info("Construction de l'objet CoursTransient avec l'id : " + cours.getId());

        // Initialisation du cours transient
        CoursTransient coursTransient = new CoursTransient();
        coursTransient.setId(cours.getId());
        coursTransient.setTitre(cours.getTitre());
        coursTransient.setIdNiveau(cours.getIdNiveau());

        // Construction des créneaux transient
        for (Creneau creneau: cours.getCreneaux()) {
            // Construit le créneau transient
            CreneauParticipantTransient creneauTransient = new CreneauParticipantTransient();
            creneauTransient.setId(creneau.getId());
            creneauTransient.setDate(creneau.getDate());
            creneauTransient.setDuree(creneau.getDuree());
            creneauTransient.setNumSalle(creneau.getNumSalle());

            // Recherche l'enseignant auprès du service Utilisateur
            this.logger.info("Demande le détail pour l'utilisateur type enseignant auprès de UtilisateurService avec l'id : " + creneau.getIdEnseignant());
            Utilisateur enseignant = this.odoruUtilisateurServiceClient.getUtilisateur((long) creneau.getIdEnseignant());
            // Construit l'enseignant (utilisateur) transient
            UtilisateurTransient enseignantTransient = new UtilisateurTransient();
            enseignantTransient.setId(enseignant.getId());
            enseignantTransient.setNom(enseignant.getNom());
            enseignantTransient.setPrenom(enseignant.getPrenom());
            enseignantTransient.setMail(enseignant.getMail());

            // Ajout de l'enseignant transient au creneau transient
            creneauTransient.setEnseignant(enseignantTransient);

            // Construction des participants transient
            for(Participant participant : creneau.getParticipants()) {
                // Recherche l'élève auprès du service Utilisateur
                this.logger.info("Demande le détail pour l'utilisateur type élève auprès de UtilisateurService avec l'id : " + participant.getIdEleve());
                Utilisateur eleve = this.odoruUtilisateurServiceClient.getUtilisateur(participant.getIdEleve());

                // Construit le participant (utilisateur) transient
                ParticipantTransient participantTransient = new ParticipantTransient();
                participantTransient.setId(eleve.getId());
                participantTransient.setNom(eleve.getNom());
                participantTransient.setPrenom(eleve.getPrenom());
                participantTransient.setMail(eleve.getMail());
                participantTransient.setPresent(participant.isPresent());

                // Ajout du participant transient au creneau transient courant
                creneauTransient.getParticipants().add(participantTransient);
            }

            // Ajout du créneau avec ses participants au cours transient
            coursTransient.getCreneaux().add(creneauTransient);
        }

        // Ajout du cours transient avec son detail à la liste de retour
        this.logger.info("L'objet CoursTransient avec l'id : " + cours.getId() + " a bien été ajouté à la liste de retour.");

        return coursTransient;
    }

    /**
     * Construit un objet cours transient selon un cours provenant de CoursService pour un enseignant
     * @param cours
     * @return
     */
    private CoursTransient factoryCoursTransientForEnseignant(Cours cours) {
        this.logger.info("Construction de l'objet CoursTransient avec l'id : " + cours.getId());

        // Initialisation du cours transient
        CoursTransient coursTransient = new CoursTransient();
        coursTransient.setId(cours.getId());
        coursTransient.setTitre(cours.getTitre());
        coursTransient.setIdNiveau(cours.getIdNiveau());

        // Construction des créneaux transient
        for (Creneau creneau: cours.getCreneaux()) {
            // Construit le créneau transient
            CreneauTransient creneauTransient = new CreneauTransient();
            creneauTransient.setId(creneau.getId());
            creneauTransient.setDate(creneau.getDate());
            creneauTransient.setDuree(creneau.getDuree());
            creneauTransient.setNumSalle(creneau.getNumSalle());

            // Ajout du créneau avec ses participants au cours transient
            coursTransient.getCreneaux().add(creneauTransient);
        }

        this.logger.info("L'objet CoursTransient avec l'id : " + cours.getId() + " a bien été ajouté à la liste de retour.");

        return coursTransient;
    }

}
