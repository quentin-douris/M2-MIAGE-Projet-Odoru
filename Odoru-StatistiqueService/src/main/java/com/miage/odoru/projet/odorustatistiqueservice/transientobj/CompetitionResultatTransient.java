package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.*;

import java.io.Serializable;

/**
 * Transient object CompetitionResultatTransient (utilisé uniquement pour la communication)
 * Permet de définir un résultat de compétition
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompetitionResultatTransient implements Serializable {
    private int idCompetition;
    private double resultat;
}
