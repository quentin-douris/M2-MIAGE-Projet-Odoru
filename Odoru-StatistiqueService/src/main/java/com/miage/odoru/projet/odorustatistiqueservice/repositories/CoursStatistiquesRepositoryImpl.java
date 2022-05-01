package com.miage.odoru.projet.odorustatistiqueservice.repositories;

import com.miage.odoru.projet.odorustatistiqueservice.clients.OdoruCoursServiceClient;
import com.miage.odoru.projet.odorustatistiqueservice.clients.OdoruUtilisateurServiceClient;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Cours;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Creneau;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Participant;
import com.miage.odoru.projet.odorustatistiqueservice.definitons.Utilisateur;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.EleveTransient;
import com.miage.odoru.projet.odorustatistiqueservice.transientobj.StatistiqueCoursEleveTransient;
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

    @Autowired
    private OdoruUtilisateurServiceClient odoruUtilisateurServiceClient;

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
            double tauxPresenceMoy = (double) nbPresence / nbParticipant;

            StatistiqueCoursPresenceTransient newStatitique = new StatistiqueCoursPresenceTransient();
            newStatitique.setTitre(cours.getTitre());
            newStatitique.setIdNiveau(cours.getIdNiveau());
            newStatitique.setTauxPresenceMoy(tauxPresenceMoy * 100);

            result.add(newStatitique);
        }

        return result;
    }

    /**
     * Calcul le nombre d'élève inscrit à un créneau de cours et la présence.
     * @param idCours
     * @param idCreneau
     * @return
     */
    @Override
    public StatistiqueCoursEleveTransient getStatistiqueNbElevesPresent(Long idCours, Long idCreneau) {
        this.logger.info("Calcul le nombre d'élève inscrit à un créneau de cours et la présence.");

        // Récupération du cours auprès du service cours
        this.logger.info("Demande le cours au service CoursService");
        Cours cours = this.odoruCoursServiceClient.getOne(idCours, idCreneau);

        // Construction de l'objet StatistiqueCoursEleveTransient
        this.logger.info("Construction de l'objet StatistiqueCoursEleveTransient.");
        StatistiqueCoursEleveTransient result = new StatistiqueCoursEleveTransient();
        result.setTitre(cours.getTitre());
        result.setIdNiveau(cours.getIdNiveau());
        result.setEleves(new ArrayList<>());

        int nbEleve = 0;

        for(Creneau creneau : cours.getCreneaux()) {
            nbEleve = creneau.getParticipants().size();
            for(Participant participant : creneau.getParticipants()) {
                Utilisateur utilisateur = this.odoruUtilisateurServiceClient.getUtilisateur(participant.getIdEleve());
                EleveTransient eleve = new EleveTransient();
                eleve.setId(utilisateur.getId());
                eleve.setNom(utilisateur.getNom());
                eleve.setPrenom(utilisateur.getPrenom());
                eleve.setPrensent(participant.isPresent());

                // Ajoute l'élève au cours
                result.getEleves().add(eleve);
            }
        }
        result.setNbEleve(nbEleve);

        return result;
    }
}
