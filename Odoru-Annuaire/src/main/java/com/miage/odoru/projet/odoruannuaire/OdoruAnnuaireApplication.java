package com.miage.odoru.projet.odoruannuaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// Active le serveur d'annuaire Eureka
@EnableEurekaServer
public class OdoruAnnuaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdoruAnnuaireApplication.class, args);
    }

}
