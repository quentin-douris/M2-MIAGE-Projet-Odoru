package com.miage.odoru.projet.odorucoursservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

// Demande a ce service de s'enregistrer auprès de l'annuaire
@EnableDiscoveryClient
public class OdoruCoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdoruCoursServiceApplication.class, args);
    }

}
