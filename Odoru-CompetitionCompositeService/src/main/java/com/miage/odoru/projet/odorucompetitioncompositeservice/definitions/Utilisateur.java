package com.miage.odoru.projet.odorucompetitioncompositeservice.definitions;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Utilisateur implements Serializable {
    private Long id;

    private String nom;

    private String prenom;

    private String mail;

    private String login;

    private String password;

    private String ville;

    private String pays;

    private int idType;

    private int idNiveau;

    private boolean isInscrit;
}
