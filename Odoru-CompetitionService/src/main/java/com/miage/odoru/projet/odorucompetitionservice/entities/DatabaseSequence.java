package com.miage.odoru.projet.odorucompetitionservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Objet qui représente la séquence utilisée pour générer un identifiant auto-incrément
 */
@Getter
@Setter
@Document(collection= "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;

    private long seq;
}
