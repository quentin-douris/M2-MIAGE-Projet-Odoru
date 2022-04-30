package com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Transient object CompetitionTransient (utilisé uniquement pour la communication)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionParticipantTransient {
    private long id;

    private String date;

    private int duree;

    private UtilisateurTransient enseignant;

    private int numSalle;

    private int idNiveau;

    private List<ParticipantTransient> participants = new ArrayList<>();
}
