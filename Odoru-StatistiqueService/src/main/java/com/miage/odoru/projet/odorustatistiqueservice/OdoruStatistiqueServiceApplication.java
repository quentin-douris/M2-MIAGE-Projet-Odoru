package com.miage.odoru.projet.odorustatistiqueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

// Demande a ce service de s'enregistrer auprès de l'annuaire
@EnableDiscoveryClient

// Pour réaliser des appels API vers d'autres micro-services
@EnableFeignClients
public class OdoruStatistiqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdoruStatistiqueServiceApplication.class, args);
    }

}
