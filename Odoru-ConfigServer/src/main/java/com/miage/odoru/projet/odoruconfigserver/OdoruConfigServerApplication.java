package com.miage.odoru.projet.odoruconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// Active le serveur de configuration
@EnableConfigServer
public class OdoruConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdoruConfigServerApplication.class, args);
    }

}
