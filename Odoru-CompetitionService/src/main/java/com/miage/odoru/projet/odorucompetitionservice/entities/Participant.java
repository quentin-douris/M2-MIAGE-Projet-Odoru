package com.miage.odoru.projet.odorucompetitionservice.entities;

import lombok.*;

/**
 * Objet qui représente un participant à une competition
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Participant {

    private long idEleve;

    private double resultat;
}
