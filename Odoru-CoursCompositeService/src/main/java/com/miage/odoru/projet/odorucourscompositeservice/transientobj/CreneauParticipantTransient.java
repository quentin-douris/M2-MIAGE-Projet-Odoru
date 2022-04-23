package com.miage.odoru.projet.odorucourscompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Transient object CreneauParticipantTransient (utilisé uniquement pour la communication)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreneauParticipantTransient extends CreneauTransient {
    private UtilisateurTransient enseignant;

    private List<ParticipantTransient> participants = new ArrayList<>();
}
