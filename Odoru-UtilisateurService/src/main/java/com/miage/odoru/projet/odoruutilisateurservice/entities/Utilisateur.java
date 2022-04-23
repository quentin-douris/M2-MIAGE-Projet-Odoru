package com.miage.odoru.projet.odoruutilisateurservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
