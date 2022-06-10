package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transient object EleveTransient (utilisé uniquement pour la communication)
 * Permet de définir un élève.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EleveTransient {
    private Long id;

    private String nom;

    private String prenom;

    private boolean isPresent;
}
