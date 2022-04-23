package com.miage.odoru.projet.odorucourscompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transient object UtilisateurTransient (utilisé uniquement pour la communication)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurTransient {
    private Long id;

    private String nom;

    private String prenom;

    private String mail;
}
