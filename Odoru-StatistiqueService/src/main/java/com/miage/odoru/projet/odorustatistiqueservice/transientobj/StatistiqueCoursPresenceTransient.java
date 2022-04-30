package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transient object StatistiqueCoursPresence (utilisé uniquement pour la communication)
 * Permet de définir le nombre de cours avec le nombre moyen d'élève présent à ce cours.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueCoursPresenceTransient {
    private String titre;

    private int idNiveau;

    private double moyPresence;
}
