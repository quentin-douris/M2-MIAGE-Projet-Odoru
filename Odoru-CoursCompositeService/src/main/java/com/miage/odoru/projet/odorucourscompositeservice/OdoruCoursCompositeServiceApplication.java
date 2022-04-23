package com.miage.odoru.projet.odorucourscompositeservice;

import com.miage.odoru.projet.odorucourscompositeservice.repositories.CoursUtilisateurRepository;
import com.miage.odoru.projet.odorucourscompositeservice.repositories.CoursUtilisateurRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

// Demande a ce service de s'enregistrer auprès de l'annuaire
@EnableDiscoveryClient

// Pour réaliser des appels API vers d'autres micro-services
@EnableFeignClients
public class OdoruCoursCompositeServiceApplication {

    /**
     * Programme principal
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OdoruCoursCompositeServiceApplication.class, args);
    }

    /**
     * Factory de bean pour gérer des cours-utilisateur
     * @return Repository de gestion de cours-utilisateur
     */
    @Bean
    public CoursUtilisateurRepository coursUtilisateurRepository() {
        return new CoursUtilisateurRepositoryImpl();
    }
}
