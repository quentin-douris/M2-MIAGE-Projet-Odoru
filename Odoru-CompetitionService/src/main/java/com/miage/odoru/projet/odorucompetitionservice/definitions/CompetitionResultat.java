package com.miage.odoru.projet.odorucompetitionservice.definitions;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompetitionResultat implements Serializable {
    private int idCompetition;
    private double resultat;
}
