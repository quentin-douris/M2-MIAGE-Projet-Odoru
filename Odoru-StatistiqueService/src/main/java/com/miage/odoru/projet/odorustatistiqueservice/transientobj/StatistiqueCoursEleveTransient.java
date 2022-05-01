package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Transient object StatistiqueCoursEleve (utilisé uniquement pour la communication)
 * Permet de définir le nombre d'élève à cours donnée avec la liste.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueCoursEleveTransient {
    private String titre;

    private int idNiveau;

    private int nbEleve;

    private List<EleveTransient> eleves;
}
