package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transient object CompetitionNiveau (utilisé uniquement pour la communication)
 * Permet de définir le nombre de compétition selon un niveau
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueCompetitionNiveau {
    private long niveau;

    private int nbCompetition;
}
