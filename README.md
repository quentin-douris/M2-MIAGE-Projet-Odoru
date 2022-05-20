# Projet Application en mode Service - Odoru

Ce projet à pour objectif de concevoir et développer une plateforme complète dotée d’un
architecture micro-services pour la gestion d’un club de danse rythmique.

La plateforme « Odoru » permet au club de gérer ses membres, de planifier des cours, des
intervenants et de gérer l’assiduité des membres du club aux différents cours.

## Architecture micro-services

![Schéma d'architecture](https://user-images.githubusercontent.com/48246043/169605387-334b67ad-07db-41d1-975b-8fb761e07112.png)

## Description des projets

Pour réaliser ce projet avec une architecture micro-service, nous avons développé et déployé 8 projets :
* __API-Gatway__ : Service qui offre une interface pour intéragir commune pour interragir avec les autres services.
* __Annuaire__ : Service qui enregistre les différents micro-services au sein d'un annuaire Eureka Server.
* __BadgeService__ : Service qui s'occupe de la gestion des badges.
* __CompetitionService__ : Service qui s'occupe de la gestion des compétions.
* __CompetitionCompositeService__ : Service qui s'occupe d'agréger les données entre le service Compétition et le service Utilisateur.
* __ConfigServer__ : Service qui s'occupe de la gestion des configurations.
* __CoursService__ : Service qui s'occupe de la gestion des cours.
* __CoursCompositeService__ : Service qui s'occupe d'agréger les données entre le service Cours et le service Utilisateur.
* __StatistiqueService__ : Service qui s'occupe de la gestion des statistiques.
* __UtilisateurService__ : Service qui s'occupe de la gestion des utilisateurs.

## Documentation API

Swagger disponible à l'URL suivante : https://app.swaggerhub.com/apis/christian.michielan/Odoru/1.0.0 

## Vidéo de démonstration

Une présentation du projet est disponible à l'url suivante :

## Exécuter le projet

Avant d'exécuter les projets, il faut exécuter le script docker-compose.yml du repo.

1. Ouvrir un terminal et se placer dans le repertoire git du projet.
2. Exécuter la commande suivante : docker-compose up
3. Attendre que les containeurs sont bien intialisés.
4. Lancer les projets manuellement.
