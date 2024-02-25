# Nom du projet

## Introduction

Une brève description de votre projet.

## Prérequis

- Java 17 JVM TEMURIN
- https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- https://sdkman.io/
- Kotlin 1.9.22
- https://kotlinlang.org/docs/command-line.html#sdkman
- Gradle 7.0
- https://gradle.org/install/

## Dependencies
- Spring Boot 3.2.2
- JUnit 5.10.2
- AssertJ 3.25.3
- Mockito 5.10.0
- Mockito-Kotlin 5.2.1
- MongoDB 4.4.9


Bien sûr, vous pouvez utiliser des versions plus récentes.

## Configuration

Pour configurer le projet, vous devez installer les prérequis mentionnés ci-dessus.
Mais aussi, vous devez installer MongoDB pour la base de données.
Pour installer MongoDB, suivez les instructions sur le site officiel : https://docs.mongodb.com/manual/installation/
Créez une base de données nommée "card" et une collection nommée "card".
Avant de lancer le projet, assurez-vous que MongoDB est en cours d'exécution.

## Installation

1. Clonez le dépôt 
2. Allez dans le dossier du projet : `cd Leitner`
3. Exécutez le script Gradle pour construire le projet : `./gradlew clean build`

## Utilisation

Pour exécuter le projet, utilisez la commande suivante : `./gradlew run`
Pour lancer les tests, utilisez la commande suivante : `./gradlew test`


## Upgrade pour une idée pour gestion des utilisateurs

Ajout de la gestion des utilisateurs avec Spring Security
Ou sinon juste utilisé une api_key pour la gestion des utilisateurs
Lors de la création d'un utilisateur, on lui attribue une api_key
Lors de la connexion, l'utilisateur doit fournir son api_key
L'api_key est stocké dans la base de données
L'api_key est unique pour chaque utilisateur
L'api_key est utilisé pour authentifier l'utilisateur
L'api_key est utilisé pour autoriser l'utilisateur à accéder à certaines ressources comme par exemple les decks elle sera dans le header de la requête
Comme preuve que l'utilisateur a le droit d'accéder à cette ressource
Comme en exemple dans le code 
Qui eux on le tenant_id qui est l'id de l'utilisateur qui a créé le deck pour savoir si l'utilisateur a le droit de le modifier ou de le supprimer
Comme ça on aura une gestion des utilisateurs sans avoir à gérer les mots de passe et les tokens
Une gestion des utilisateurs simple et sécurisée
La card possèdera un tenant_id qui nous permettra de savoir à qui appartient la card

