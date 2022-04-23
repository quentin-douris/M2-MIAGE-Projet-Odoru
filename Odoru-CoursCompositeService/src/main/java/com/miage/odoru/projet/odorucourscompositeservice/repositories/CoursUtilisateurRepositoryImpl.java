package com.miage.odoru.projet.odorucourscompositeservice.repositories;

import com.miage.odoru.projet.odorucourscompositeservice.clients.OdoruCoursServiceClient;
import com.miage.odoru.projet.odorucourscompositeservice.clients.OdoruUtilisateurServiceClient;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Cours;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Creneau;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Participant;
import com.miage.odoru.projet.odorucourscompositeservice.definitions.Utilisateur;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.CoursTransient;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.CreneauTransient;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.ParticipantTransient;
import com.miage.odoru.projet.odorucourscompositeservice.transientobj.UtilisateurTransient;
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
        List<CoursTransient> result = new ArrayList<CoursTransient>();

        // Construction de l'objet CoursTransient
        for (Iterator<Cours> coursIterator = coursList.iterator(); coursIterator.hasNext();) {
            Cours cours = coursIterator.next();

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

                // Recherche l'enseignant auprès du service Utilisateur
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
            result.add(coursTransient);
        }

        return result;
    }
}
