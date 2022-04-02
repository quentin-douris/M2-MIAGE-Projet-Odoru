package com.miage.odoru.projet.odorucoursservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Entité qui représente un cours dans la base de données NoSQL
 */
@Document(collection = "cours")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cours {
    @Id
    private long id;

    @Field
    private String titre;

    @Field
    private int idNiveau;

    @Field
    private List<Creneau> creneaux;
}
