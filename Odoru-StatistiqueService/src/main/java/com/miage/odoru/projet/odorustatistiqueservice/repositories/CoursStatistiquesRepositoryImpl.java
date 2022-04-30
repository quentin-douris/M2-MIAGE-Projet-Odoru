package com.miage.odoru.projet.odorustatistiqueservice.repositories;

import com.miage.odoru.projet.odorustatistiqueservice.clients.OdoruCoursServiceClient;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Cours;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Creneau;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Participant;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursPresenceTransient;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe qui permet de manipuler techniquement nos objets provenant du service Cours
 */
@NoArgsConstructor
public class CoursStatistiquesRepositoryImpl implements CoursStatistiqueRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OdoruCoursServiceClient odoruCoursServiceClient;

    /**
     * Calcul le nombre de créneau dispensé pour un cours et la présence moyenne des participants à ce cours sur tous les créneaux.
     * @return
     */
    @Override
    public Iterable<StatistiqueCoursPresenceTransient> getStatistiqueCoursPresence() {
        this.logger.info("Obtenir tous les cours enregistrés dans le système avec le détail de leurs informations");

        // Récupération de tous les cours auprès du service Cours
        this.logger.info("Demande les cours au service CoursService");
        Iterable<Cours> coursList = this.odoruCoursServiceClient.getAllCours();

        // Variable qui va contenir notre résultat
        List<StatistiqueCoursPresenceTransient> result = new ArrayList<>();

        // Construction de l'objet CoursTransient
        this.logger.info("Construction de la liste des CoursTransient.");
        for (Iterator<Cours> coursIterator = coursList.iterator(); coursIterator.hasNext();) {
            Cours cours = coursIterator.next();
            int nbPresence = 0;
            int nbParticipant = 0;

            for (Creneau creneau : cours.getCreneaux()) {
                nbParticipant += creneau.getParticipants().size();
                for (Participant participant: creneau.getParticipants()) {
                    if(participant.isPresent()) {
                        nbPresence++;
                    }
                }
            }
            double moyPresence = (double) nbPresence / nbParticipant;

            StatistiqueCoursPresenceTransient newStatitique = new StatistiqueCoursPresenceTransient();
            newStatitique.setTitre(cours.getTitre());
            newStatitique.setIdNiveau(cours.getIdNiveau());
            newStatitique.setMoyPresence(moyPresence);

            result.add(newStatitique);
        }

        return result;
    }
}
