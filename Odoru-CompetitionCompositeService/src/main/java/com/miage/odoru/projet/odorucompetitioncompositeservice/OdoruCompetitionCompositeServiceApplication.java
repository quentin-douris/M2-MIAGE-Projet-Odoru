package com.miage.odoru.projet.odorucompetitioncompositeservice;

import com.miage.odoru.projet.odorucompetitioncompositeservice.repositories.CompetitionUtilisateurRepository;
import com.miage.odoru.projet.odorucompetitioncompositeservice.repositories.CompetitionUtilisateurRepositoryImpl;
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
public class OdoruCompetitionCompositeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdoruCompetitionCompositeServiceApplication.class, args);
    }

    /**
     * Factory de bean pour gérer des competition-utilisateur
     * @return Repository de gestion de competition-utilisateur
     */
    @Bean
    public CompetitionUtilisateurRepository competitionUtilisateurRepository() {
        return new CompetitionUtilisateurRepositoryImpl();
    }

}
