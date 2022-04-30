package com.miage.odoru.projet.odorucompetitioncompositeservice.definitions;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Participant implements Serializable {
    private long idEleve;

    private double resultat;
}
