package com.miage.odoru.projet.odorustatistiqueservice.definitons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objet définition qui permet d'interpréter le retour API pour un type Compétition auprès du service Compétition
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Competition implements Serializable {
    private long id;

    private String date;

    private int duree;

    private long idEnseignant;

    private int numSalle;

    private int idNiveau;

    private List<ParticipantCompetition> participants = new ArrayList<>();
}
