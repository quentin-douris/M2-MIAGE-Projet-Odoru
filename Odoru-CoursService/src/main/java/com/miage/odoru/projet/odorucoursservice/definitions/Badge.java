package com.miage.odoru.projet.odorucoursservice.definitions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Objet définition qui permet d'interpréter le retour API pour un type Badge auprès du service badge
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Badge implements Serializable {
    private Long idBadge;

    private Long idUtilisateur;
}
