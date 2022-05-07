package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Transient object StatistiqueCoursCreneauxPresence (utilisé uniquement pour la communication)
 * Permet de définir la liste des courzs pour un élève donné avec un indicateur de présence au cours.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueCoursCreneauxPresence {
    private String titre;

    private int idNiveau;

    private List<CreneauTransient> creneaux;
}
