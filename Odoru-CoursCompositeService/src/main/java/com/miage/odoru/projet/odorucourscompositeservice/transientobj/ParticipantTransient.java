package com.miage.odoru.projet.odorucourscompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transient object ParticipantTransient (utilisé uniquement pour la communication)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantTransient extends UtilisateurTransient {
    private boolean isPresent;
}
