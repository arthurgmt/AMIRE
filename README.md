# AMIRE
 application de mise en relation entre des enseignants et des ecoles



dans le dossier AMIRE :

- 'mvn clean install' après avoir modifié le pom.xml pour installer les dependances
- 'mvn tomcat:run' pour lancer le serveur tomcat

- 'docker compose up -d' pour lancer la base de données (-d pour lancer en arrière plan)
- 'docker compose down' pour arrêter la base de données
- 'docker compose down -v' pour arrêter la base de données et supprimer les données

Déploiement wildfly :

install extensions : Runtime Server Protocol UI, Community Server Connectors, Server connector
add wildfly server : cmd + shift + p -> add server -> wildfly -> path to wildfly folder (or download it) (wildfly-30.0.0.Final)
mvn clean install => give a war archive in target folder AMIRE/target/AMIRE.war
add war to deploy : right click on wildfly server -> add war to deploy -> select war file or add war to standalone/deployments folder of wildfly installation
start wildfly server : right click on wildfly server -> start server war : .war project is accessible on localhost:8080/AMIRE localhost:8080/
