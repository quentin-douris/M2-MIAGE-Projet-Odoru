package com.miage.odoru.projet.odorucourscompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Transient object CoursTransient (utilisé uniquement pour la communication)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursTransient {
    private long id;

    private String titre;

    private int idNiveau;

    private List<CreneauTransient> creneaux = new ArrayList<>();
}
