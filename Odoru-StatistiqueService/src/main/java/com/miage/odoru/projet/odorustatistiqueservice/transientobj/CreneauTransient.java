package com.miage.odoru.projet.odorustatistiqueservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transient object CreneauTransient (utilisé uniquement pour la communication)
 * Permet de définir un créneau
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreneauTransient {
    private String date;

    private boolean isPresent;
}
