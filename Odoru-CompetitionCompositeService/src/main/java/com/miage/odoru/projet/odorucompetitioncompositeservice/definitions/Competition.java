package com.miage.odoru.projet.odorucompetitioncompositeservice.definitions;

import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.UtilisateurTransient;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Competition implements Serializable {
    private long id;

    private String date;

    private int duree;

    private long idEnseignant;

    private int numSalle;

    private int idNiveau;

    private List<Participant> participants = new ArrayList<Participant>();
}
