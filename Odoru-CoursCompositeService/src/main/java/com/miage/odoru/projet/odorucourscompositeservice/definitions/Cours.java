package com.miage.odoru.projet.odorucourscompositeservice.definitions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objet définition qui permet d'interpréter le retour API pour un type Cours auprès du service Cours
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours implements Serializable {
    private long id;

    private String titre;

    private int idNiveau;

    private List<Creneau> creneaux = new ArrayList<>();
}

