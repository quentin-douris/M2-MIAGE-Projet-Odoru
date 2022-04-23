package com.miage.odoru.projet.odorucourscompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Transient object CreneauTransient (utilisé uniquement pour la communication)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreneauTransient {
    private Long id;

    private String date;

    private int duree;

    private UtilisateurTransient enseignant;

    private int numSalle;

    private List<ParticipantTransient> participants = new ArrayList<>();
}
