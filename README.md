# Projet Application en mode Service - Odoru

Ce projet à pour objectif de concevoir et développer une plateforme complète dotée d’un
architecture micro-services pour la gestion d’un club de danse rythmique.

La plateforme « Odoru » permet au club de gérer ses membres, de planifier des cours, des
intervenants et de gérer l’assiduité des membres du club aux différents cours.

## Architecture micro-services

![Schéma d'architecture](https://user-images.githubusercontent.com/48246043/159720316-5382d66e-b36d-4225-bfb8-ff0e9522efec.png)

## Description des projets

Pour réaliser ce projet avec une architecture micro-service, nous avons développé et déployé 8 projets :
* __API-Gatway__ : Service qui offre une interface pour intéragir commune pour interragir avec les autres services.
* __Annuaire__ : Service qui enregistre les différents micro-services au sein d'un annuaire Eureka Server.
* __BadgeService__ : Service qui s'occupe de la gestion des badges.
* __CompetitionService__ : Service qui s'occupe de la gestion des compétions.
* __ConfigServer__ : Service qui s'occupe de la gestion des configurations.
* __CoursService__ : Service qui s'occupe de la gestion des cours.
* __StatistiqueService__ : Service qui s'occupe de la gestion des statistiques.
* __UtilisateurService__ : Service qui s'occupe de la gestion des utilisateurs.

## Exécuter le projet

Avant d'exécuter les projets, il exécuter le script docker-compose.yml du repo.

1. Ouvrir un terminal et se placer dans le repertoire git du projet.
2. Exécuter la commande suivante : docker-compose up
3. Attendre que les containeurs sont bien intialisés.
4. Lancer les projets manuellement.


__Attention__ : pour le moment tous les projets doivent être __lancé manuellement__. Nous automatisserons leur exécution avec la conteneurisation quand les services seront développés. 