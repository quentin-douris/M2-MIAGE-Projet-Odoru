package com.miage.odoru.projet.odorucourscompositeservice.definitions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objet définition qui permet d'interpréter le retour API pour un type Creneau auprès du service Cours
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Creneau implements Serializable {
    private Long id;

    private String date;

    private int duree;

    private int idEnseignant;

    private int numSalle;

    private List<Participant> participants = new ArrayList<>();
}
