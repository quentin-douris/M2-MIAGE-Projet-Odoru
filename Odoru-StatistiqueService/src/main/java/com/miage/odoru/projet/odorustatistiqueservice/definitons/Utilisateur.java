package com.miage.odoru.projet.odorustatistiqueservice.definitons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Objet définition qui permet d'interpréter le retour API pour un type Utilisateur auprès du service Utilisateur
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {
    private Long id;

    private String nom;

    private String prenom;

    private int idType;

    private int idNiveau;
}
