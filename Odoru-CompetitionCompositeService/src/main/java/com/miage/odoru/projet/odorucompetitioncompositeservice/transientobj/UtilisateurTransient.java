package com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurTransient {
    private Long id;

    private String nom;

    private String prenom;

    private String mail;
}
