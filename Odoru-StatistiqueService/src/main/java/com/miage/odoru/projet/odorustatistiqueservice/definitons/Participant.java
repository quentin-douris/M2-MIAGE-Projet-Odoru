package com.miage.odoru.projet.odorustatistiqueservice.definitons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Objet définition qui permet d'interpréter le retour API pour un type Participant auprès du service Cours
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participant implements Serializable {
    private long idEleve;

    private boolean isPresent;
}
