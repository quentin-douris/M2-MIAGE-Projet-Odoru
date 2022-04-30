package com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParticipantTransient extends UtilisateurTransient{
    private double resultat;
}
