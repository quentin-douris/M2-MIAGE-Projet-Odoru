package com.miage.odoru.projet.odorucoursservice.entities;

import lombok.*;

/**
 * Objet qui représente un participant sur un créneau d'un cours
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Participant {

    private int idEleve;

    private boolean isPresent;
}
