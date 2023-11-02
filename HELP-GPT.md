
### 1. Pré-requis :

**1.1.** Assurez-vous d'avoir installé Java Development Kit (JDK).

**1.2.** Installez Visual Studio Code et les extensions nécessaires: "Maven for Java", "Java Extension Pack" et "Community Server Connectors".

**1.3.** Téléchargez et installez [Apache Tomcat](https://tomcat.apache.org/download-90.cgi). Pour cet exemple, nous utiliserons Tomcat 9.0.

### 2. Création du projet :

**2.1.** Ouvrez le terminal dans VSCode et tapez :

```bash
mvn archetype:generate -DgroupId=com.votreNom -DartifactId=nomDuProjet -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

Changez `com.votreNom` par votre nom de domaine (ou tout autre identifiant) et `nomDuProjet` par le nom que vous souhaitez donner à votre projet.

### 3. Configuration du projet :

**3.1.** Ouvrez `pom.xml` et ajoutez les dépendances pour Servlets et JSP.

### 4. Structure du projet :

Organisez le projet comme mentionné dans le message précédent.

### 5. Configuration de Tomcat dans VSCode :

**5.1.** Après avoir installé l'extension "Community Server Connectors", ouvrez la vue "Serveurs" dans la barre latérale.

**5.2.** Cliquez sur "+" pour ajouter un nouveau serveur.

**5.3.** Choisissez "Tomcat" et indiquez le chemin d'accès au répertoire d'installation de Tomcat.

**5.4.** Vous verrez alors "Tomcat 9.0" apparaître dans la liste des serveurs.

### 6. Déploiement de l'application :

**6.1.** Dans la vue "Serveurs", faites un clic droit sur "Tomcat 9.0" et choisissez "Ajouter un war à déployer".

**6.2.** Sélectionnez le fichier `.war` de votre application (généralement situé dans le dossier `target` après avoir exécuté `mvn clean install`).

**6.3.** Cliquez sur "Démarrer le serveur" pour lancer Tomcat et déployer votre application.

**6.4.** Vous pouvez accéder à votre application à l'adresse : `http://localhost:8080/nomDuProjet`.

### Remarques :

- Les étapes ci-dessus sont une introduction de haut niveau. Vous devrez configurer les servlets, les modèles, les DAO, etc. comme décrit dans le message précédent.
- Assurez-vous de tester régulièrement votre application pour vous assurer qu'elle fonctionne comme prévu.
- Si vous rencontrez des problèmes avec Tomcat dans VSCode, n'hésitez pas à consulter la documentation ou à chercher des solutions en ligne. La communauté Java est vaste et vous trouverez probablement quelqu'un ayant rencontré un problème similaire.






Déploiement wildfly :

install extensions : Runtime Server Protocol UI, Community Server Connectors, Server connector

add wildfly server : cmd + shift + p -> add server -> wildfly -> path to wildfly folder (or download it) (wildfly-30.0.0.Final)

mvn clean install => give a war archive in target folder AMIRE/target/AMIRE.war

add war to deploy : right click on wildfly server -> add war to deploy -> select war file
or add war to standalone/deployments folder of wildfly installation

start wildfly server : right click on wildfly server -> start server
                                                war : <name>.war
project is accessible on localhost:8080/AMIRE   localhost:8080/<name>
