package com.miage.odoru.projet.odorucompetitionservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Entité qui représente une compétition dans la BDD NoSQL
 */
@Document(collection = "competition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Competition {

    @Transient
    public static final String SEQUENCE_NAME = "competition_sequence";

    @Id
    private long id;

    @Field
    private String date;

    @Field
    private int duree;

    @Field
    private long idEnseignant;

    @Field
    private int numSalle;

    @Field
    private int idNiveau;

    @Field
    private List<Participant> participants = new ArrayList<>();
}
