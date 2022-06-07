package com.miage.odoru.projet.odoruutilisateurservice.dbinit;

import com.miage.odoru.projet.odoruutilisateurservice.entities.Utilisateur;
import com.miage.odoru.projet.odoruutilisateurservice.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class dbInit {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @PostConstruct
    private void initDb() {
        this.initEleve();
        this.initSecretaire();
        this.initEnseignant();
        this.initPresient();
    }

    /**
     * Initialise un jeu de données d'utilisateurs type : élève (nombre : 9)
     */
    private void initEleve() {
        // Eleves niveau débutant
        Utilisateur u1 = new Utilisateur();
        u1.setPrenom("Maxime");
        u1.setNom("Dupon");
        u1.setIdNiveau(1);
        u1.setIdType(1);
        u1.setMail("maxime.dupon@mail.fr");
        u1.setLogin("eleve1");
        u1.setPassword("password");
        u1.setVille("Toulouse");
        u1.setPays("France");
        u1.setInscrit(true);
        this.utilisateurRepository.save(u1);

        Utilisateur u2 = new Utilisateur();
        u2.setPrenom("Léa");
        u2.setNom("Porte");
        u2.setIdNiveau(1);
        u2.setIdType(1);
        u2.setMail("lea.porte@mail.fr");
        u2.setLogin("eleve2");
        u2.setPassword("password");
        u2.setVille("Toulouse");
        u2.setPays("France");
        u2.setInscrit(true);
        this.utilisateurRepository.save(u2);

        Utilisateur u3 = new Utilisateur();
        u3.setPrenom("Elise");
        u3.setNom("Gyli");
        u3.setIdNiveau(1);
        u3.setIdType(1);
        u3.setMail("elise.gyli@mail.fr");
        u3.setLogin("eleve3");
        u3.setPassword("password");
        u3.setVille("Toulouse");
        u3.setPays("France");
        u3.setInscrit(true);
        this.utilisateurRepository.save(u3);

        // Eleves niveau moyen
        Utilisateur u4 = new Utilisateur();
        u4.setPrenom("Thomas");
        u4.setNom("Dell");
        u4.setIdNiveau(2);
        u4.setIdType(1);
        u4.setMail("thomas.dell@mail.fr");
        u4.setLogin("eleve4");
        u4.setPassword("password");
        u4.setVille("Toulouse");
        u4.setPays("France");
        u4.setInscrit(true);
        this.utilisateurRepository.save(u4);

        Utilisateur u5 = new Utilisateur();
        u5.setPrenom("Léo");
        u5.setNom("Candy");
        u5.setIdNiveau(2);
        u5.setIdType(1);
        u5.setMail("leo.candy@mail.fr");
        u5.setLogin("eleve5");
        u5.setPassword("password");
        u5.setVille("Toulouse");
        u5.setPays("France");
        u5.setInscrit(true);
        this.utilisateurRepository.save(u5);

        Utilisateur u6 = new Utilisateur();
        u6.setPrenom("Camille");
        u6.setNom("Logitech");
        u6.setIdNiveau(2);
        u6.setIdType(1);
        u6.setMail("camille.logitech@mail.fr");
        u6.setLogin("eleve6");
        u6.setPassword("password");
        u6.setVille("Toulouse");
        u6.setPays("France");
        u6.setInscrit(true);
        this.utilisateurRepository.save(u6);

        // Eleves niveau expert
        Utilisateur u7 = new Utilisateur();
        u7.setPrenom("Blanche");
        u7.setNom("Apple");
        u7.setIdNiveau(3);
        u7.setIdType(1);
        u7.setMail("blanche.apple@mail.fr");
        u7.setLogin("eleve7");
        u7.setPassword("password");
        u7.setVille("Toulouse");
        u7.setPays("France");
        u7.setInscrit(true);
        this.utilisateurRepository.save(u7);

        Utilisateur u8 = new Utilisateur();
        u8.setPrenom("Iris");
        u8.setNom("Intel");
        u8.setIdNiveau(3);
        u8.setIdType(1);
        u8.setMail("iris.intel@mail.fr");
        u8.setLogin("eleve8");
        u8.setPassword("password");
        u8.setVille("Toulouse");
        u8.setPays("France");
        u8.setInscrit(true);
        this.utilisateurRepository.save(u8);

        Utilisateur u9 = new Utilisateur();
        u9.setPrenom("Pierre");
        u9.setNom("hp");
        u9.setIdNiveau(3);
        u9.setIdType(1);
        u9.setMail("pierre.hp@mail.fr");
        u9.setLogin("eleve9");
        u9.setPassword("password");
        u9.setVille("Toulouse");
        u9.setPays("France");
        u9.setInscrit(true);
        this.utilisateurRepository.save(u9);
    }

    /**
     * Initialise un jeu de données d'utilisateurs type : secrétaire (nombre : 1)
     */
    private void initSecretaire() {
        Utilisateur s1 = new Utilisateur();
        s1.setPrenom("Sylvie");
        s1.setNom("Dupon");
        s1.setIdNiveau(1);
        s1.setIdType(2);
        s1.setMail("sylvie.dupon@odoru.fr");
        s1.setLogin("secretaire1");
        s1.setPassword("password");
        s1.setVille("Toulouse");
        s1.setPays("France");
        s1.setInscrit(true);
        this.utilisateurRepository.save(s1);
    }

    /**
     * Initialise un jeu de données d'utilisateurs type : enseignant (nombre : 2)
     */
    private void initEnseignant() {
        // Enseignant de niveau : débutant
        Utilisateur e1 = new Utilisateur();
        e1.setPrenom("Etienne");
        e1.setNom("Fourcade");
        e1.setIdNiveau(1);
        e1.setIdType(3);
        e1.setMail("etienne.fourcade@odoru.fr");
        e1.setLogin("enseignant1");
        e1.setPassword("password");
        e1.setVille("Toulouse");
        e1.setPays("France");
        e1.setInscrit(true);
        this.utilisateurRepository.save(e1);

        // Enseignant de niveau : expert
        Utilisateur e2 = new Utilisateur();
        e2.setPrenom("Sandrine");
        e2.setNom("Lean");
        e2.setIdNiveau(3);
        e2.setIdType(3);
        e2.setMail("sandrine.lean@odoru.fr");
        e2.setLogin("enseignant2");
        e2.setPassword("password");
        e2.setVille("Toulouse");
        e2.setPays("France");
        e2.setInscrit(true);
        this.utilisateurRepository.save(e2);
    }

    /**
     * Initialise un jeu de données d'utilisateurs type : président (nombre : 1)
     */
    private void initPresient() {
        Utilisateur p1 = new Utilisateur();
        p1.setPrenom("Emmanuel");
        p1.setNom("Agile");
        p1.setIdNiveau(3);
        p1.setIdType(4);
        p1.setMail("emmanuel.agile@odoru.fr");
        p1.setLogin("president1");
        p1.setPassword("password");
        p1.setVille("Toulouse");
        p1.setPays("France");
        p1.setInscrit(true);
        this.utilisateurRepository.save(p1);
    }
}