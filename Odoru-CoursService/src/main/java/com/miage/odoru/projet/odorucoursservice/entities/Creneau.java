package com.miage.odoru.projet.odorucoursservice.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Creneau {

    private Long id;

    private String date;

    private int duree;

    private int idEnseignant;

    private int numSalle;

    private List<Participant> participants;
}
