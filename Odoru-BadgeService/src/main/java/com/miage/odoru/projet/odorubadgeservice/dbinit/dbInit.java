package com.miage.odoru.projet.odorubadgeservice.dbinit;

import com.miage.odoru.projet.odorubadgeservice.entities.Badge;
import com.miage.odoru.projet.odorubadgeservice.repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class dbInit {
    @Autowired
    BadgeRepository badgeRepository;

    @PostConstruct
    private void dbInit() {
        this.initBadgeEleve();
        this.initBadgeSecretaire();
        this.initBadgeEnseignant();
        this.initBadgePresident();
    }

    /**
     * Initialise un jeu de données pour les badges des utilisateurs de type : élève (nombre : 9)
     */
    private void initBadgeEleve() {
        Badge badgeE1 = new Badge();
        badgeE1.setIdUtilisateur(1L);
        this.badgeRepository.save(badgeE1);

        Badge badgeE2 = new Badge();
        badgeE2.setIdUtilisateur(2L);
        this.badgeRepository.save(badgeE2);

        Badge badgeE3 = new Badge();
        badgeE3.setIdUtilisateur(3L);
        this.badgeRepository.save(badgeE3);

        Badge badgeE4 = new Badge();
        badgeE4.setIdUtilisateur(4L);
        this.badgeRepository.save(badgeE4);

        Badge badgeE5 = new Badge();
        badgeE5.setIdUtilisateur(5L);
        this.badgeRepository.save(badgeE5);

        Badge badgeE6 = new Badge();
        badgeE6.setIdUtilisateur(6L);
        this.badgeRepository.save(badgeE6);

        Badge badgeE7 = new Badge();
        badgeE7.setIdUtilisateur(7L);
        this.badgeRepository.save(badgeE7);

        Badge badgeE8 = new Badge();
        badgeE8.setIdUtilisateur(8L);
        this.badgeRepository.save(badgeE8);

        Badge badgeE9 = new Badge();
        badgeE9.setIdUtilisateur(9L);
        this.badgeRepository.save(badgeE9);
    }

    /**
     * Initialise un jeu de données pour les badges des utilisateurs de type : secrétaire (nombre : 1)
     */
    public void initBadgeSecretaire() {
        Badge badgeS1 = new Badge();
        badgeS1.setIdUtilisateur(10L);
        this.badgeRepository.save(badgeS1);
    }

    /**
     * Initialise un jeu de données pour les badges des utilisateurs de type : enseignant (nombre : 2)
     */
    public void initBadgeEnseignant() {
        Badge badgeE1 = new Badge();
        badgeE1.setIdUtilisateur(11L);
        this.badgeRepository.save(badgeE1);

        Badge badgeE2 = new Badge();
        badgeE2.setIdUtilisateur(12L);
        this.badgeRepository.save(badgeE2);
    }

    /**
     * Initialise un jeu de données pour les badges des utilisateurs de type : président (nombre : 1)
     */
    public void initBadgePresident() {
        Badge badgeP1 = new Badge();
        badgeP1.setIdUtilisateur(13L);
        this.badgeRepository.save(badgeP1);
    }
}
