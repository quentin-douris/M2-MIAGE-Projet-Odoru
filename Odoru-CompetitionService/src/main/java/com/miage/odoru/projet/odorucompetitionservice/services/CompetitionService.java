package com.miage.odoru.projet.odorucompetitionservice.services;

import com.miage.odoru.projet.odorucompetitionservice.entities.Competition;
import com.miage.odoru.projet.odorucompetitionservice.exceptions.EnseignantMauvaisNiveauException;
import com.miage.odoru.projet.odorucompetitionservice.exceptions.MauvaiseDateException;

import java.text.ParseException;

/**
 * Interface du service qui s'occupe de la gestion des Competitions
 */
public interface CompetitionService {

    /**
     * Permet d'ajouter une compétition
     * @param competition
     * @return
     */
    Competition ajouterCompetition(Competition competition) throws MauvaiseDateException, ParseException, EnseignantMauvaisNiveauException;

    /**
     * Permet d'obtenir les competitions
     * @return
     */
    Iterable<Competition> obtenirLesCompetitions();

    /**
     * Permet d'obtenir les competitions selon un niveau
     * @param idNiveau
     * @return
     */
    Iterable<Competition> obtenirLesCompetitionsSelonNiveau(int idNiveau);

    /**
     * Permet d'obtenir les competitions selon l'id de l'enseignant
     * @param idEnseignant
     * @return
     */
    Iterable<Competition> obtenirLesCompetitionsSelonEnseignant(long idEnseignant);

    /**
     * Permet d'obtenir les competitions selon un id de participant (idEleve)
     * @param idParticipant
     * @return
     */
    Iterable<Competition> obtenirLesCompetitionsSelonParticipant(int idParticipant);


    /**
     * Méthode permettant de mettre à jour le résultat d'une compétition pour un participant
     * @param idCompetition
     * @param idParticipant
     * @param resultat
     * @return
     */
    Competition miseAJourResultatCompetition(int idCompetition, int idParticipant, double resultat);
}
