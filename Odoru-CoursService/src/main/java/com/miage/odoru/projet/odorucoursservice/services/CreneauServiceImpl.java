package com.miage.odoru.projet.odorucoursservice.services;

import com.miage.odoru.projet.odorucoursservice.clients.OdoruUtilisateurServiceClient;
import com.miage.odoru.projet.odorucoursservice.definitions.Utilisateur;
import com.miage.odoru.projet.odorucoursservice.entities.Cours;
import com.miage.odoru.projet.odorucoursservice.entities.Creneau;
import com.miage.odoru.projet.odorucoursservice.entities.Participant;
import com.miage.odoru.projet.odorucoursservice.exceptions.CoursInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.CreneauInconnuException;
import com.miage.odoru.projet.odorucoursservice.exceptions.EnseignantInapteException;
import com.miage.odoru.projet.odorucoursservice.exceptions.PlanificationCreneauException;
import com.miage.odoru.projet.odorucoursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Service qui s'occupe de la gestion des Créneaux
 */
@Service
public class CreneauServiceImpl implements CreneauService {
    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    CoursRepository coursRepository;

    @Autowired
    OdoruUtilisateurServiceClient odoruUtilisateurServiceClient;

    /**
     * Ajoute un nouveau créneau à un cours dans le système
     * @param cours
     * @param creneau
     * @return
     * @throws CoursInconnuException
     * @throws PlanificationCreneauException
     */
    @Override
    public Cours ajouterCreneauCours(Cours cours, Creneau creneau) throws CoursInconnuException, PlanificationCreneauException, EnseignantInapteException {
        // Recherche le cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());

        // Si le cours n'est pas trouvé dans le système
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }

        // Vérifie que la date du créneau respect bien les 7jours entre la date de saisie et la date du créneau
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss") ;
        Date dateconvert = null;

        try {
            dateconvert = df.parse(creneau.getDate());
        } catch(Exception ex) {
            throw new PlanificationCreneauException();
        }

        // Conversion de la date du jour + 7
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss'Z'");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +7);
        Date todateDateFuture = cal.getTime();
        // Verif
        if (dateconvert.before(todateDateFuture)) {
            throw new PlanificationCreneauException();
        }

        // Vérifie que l'enseignant et apte à créer ce créneau de cours
        Utilisateur enseignant = this.odoruUtilisateurServiceClient.getUtilisateurById((long)creneau.getIdEnseignant());
        if(enseignant.getIdNiveau() < cours.getIdNiveau()) {
            throw new EnseignantInapteException(enseignant.getIdNiveau(), cours.getIdNiveau());
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

        // Ajoute tous les utilisateurs qui ont le niveau pour ce créneau (sauf l'enseignant)
        Iterable<Utilisateur> utilisateurList = this.odoruUtilisateurServiceClient.getUtilisateurByIdNiveau(cours.getIdNiveau());
        for (Iterator<Utilisateur> utilisateurIterator = utilisateurList.iterator(); utilisateurIterator.hasNext();) {
            Utilisateur utilisateur = utilisateurIterator.next();
            if(utilisateur.getId() != enseignant.getId()) {
                // Créer un nouveau participant
                Participant newParticipant = new Participant();
                newParticipant.setIdEleve(utilisateur.getId());
                // Ajout le participant au cours
                creneau.getParticipants().add(newParticipant);
            }
        }

        // Ajoute le nouveau créneau au cours
        cours.getCreneaux().add(creneau);

        // Sauvegarde le cours dans le système
        return this.coursRepository.save(cours);
    }

    /**
     * Obtenir un creneau de cours spécifique
     * @param cours
     * @param idCreneau
     * @return
     * @throws CoursInconnuException
     * @throws CreneauInconnuException
     */
    @Override
    public Cours obtenirCreneauCours(Cours cours, Long idCreneau) throws CoursInconnuException, CreneauInconnuException {
        // Recherche le cours
        Optional<Cours> optionalCours = this.coursRepository.findById(cours.getId());

        // Si le cours n'est pas trouvé dans le système
        if(optionalCours.isEmpty()) {
            throw new CoursInconnuException(cours.getId());
        }

        // Recherche le créneau pour le cours
        Cours resultCreneau = mongoOperations.query(Cours.class)
                .matching(query(where("id").is(cours.getId()).and("creneaux.id").is(idCreneau)))
                .firstValue();

        if (resultCreneau == null) {
            throw new CreneauInconnuException(cours.getId(), idCreneau);
        }

        // Objet pour le retour
        Cours toReturn = new Cours();
        toReturn.setId(resultCreneau.getId());
        toReturn.setTitre(resultCreneau.getTitre());
        toReturn.setIdNiveau(resultCreneau.getIdNiveau());

        for (Iterator<Creneau> creneauIterator = resultCreneau.getCreneaux().iterator(); creneauIterator.hasNext();) {
            Creneau creneau = creneauIterator.next();
            if(creneau.getId() == idCreneau) {
                // Supprime le créneau du retour
                toReturn.getCreneaux().add(creneau);
            }
        }

        return toReturn;
    }
}