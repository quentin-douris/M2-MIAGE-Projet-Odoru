package com.miage.odoru.projet.odorustatistiqueservice;

import com.miage.odoru.projet.odorustatistiqueservice.repositories.CompetitionStatistiqueRepository;
import com.miage.odoru.projet.odorustatistiqueservice.repositories.CompetitionStatistiqueRepositoryImpl;
import com.miage.odoru.projet.odorustatistiqueservice.repositories.CoursStatistiqueRepository;
import com.miage.odoru.projet.odorustatistiqueservice.repositories.CoursStatistiquesRepositoryImpl;
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
public class OdoruStatistiqueServiceApplication {

    /**
     * Programme principal
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OdoruStatistiqueServiceApplication.class, args);
    }

    /**
     * Factory de bean pour gérer des cours-statistique
     * @return Repository de gestion de cours-statistique
     */
    @Bean
    public CoursStatistiqueRepository coursStatistiqueRepository() {
        return new CoursStatistiquesRepositoryImpl();
    }

    /**
     * Factory de bean pour gérer des competition-statistique
     * @return Repository de gestion de competition-statistique
     */
    @Bean
    public CompetitionStatistiqueRepository competitionStatistiqueRepository() {
        return new CompetitionStatistiqueRepositoryImpl();
    }
}
