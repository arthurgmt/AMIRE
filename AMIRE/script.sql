-- CREATE DATABASE Amire;
-- USE Amire;
CREATE TABLE Utilisateur(
    ID SERIAL PRIMARY KEY,
    Nom VARCHAR(255) NOT NULL ,
    Prenom VARCHAR(255) NOT NULL,
    Mail VARCHAR(255) NOT NULL,
    MotDePasse VARCHAR(255) NOT NULL,
    Role VARCHAR(50)  NOT NULL
);
CREATE TABLE Enseignant (
    ID SERIAL PRIMARY KEY,
    UtilisateurID INT NOT NULL,
    Experience INT,
    Telephone VARCHAR(20) NOT NULL,
    SiteWeb VARCHAR(255),
    NiveauxSouhaites VARCHAR(255),
    Disponibilites DATE NOT NULL,
    TypeContrat VARCHAR(50),
    TitresAcademiques TEXT,
    Evaluations TEXT,
    AutresInformations TEXT,
    Competences TEXT NOT NULL,
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(ID)
);
CREATE TABLE Ecole (
    ID SERIAL PRIMARY KEY,
    UtilisateurID INT NOT NULL,
    RaisonSociale VARCHAR(255) NOT NULL,
    Adresse TEXT NOT NULL,
    SiteWeb VARCHAR(255),
    Contact VARCHAR(255),
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(ID),
    Nom VARCHAR(255) NOT NULL
);
CREATE TABLE Besoin (
    ID SERIAL PRIMARY KEY,
    EcoleID INT NOT NULL,
    Periode VARCHAR(255) NOT NULL,
    Remarques TEXT,
    Competences TEXT NOT NULL,
    FOREIGN KEY (EcoleID) REFERENCES Ecole(ID)
);
CREATE TABLE Decision (
    ID SERIAL PRIMARY KEY,
    Statut VARCHAR(50) NOT NULL,
    DateDecision DATE NOT NULL,
    Commentaires TEXT
);
CREATE TABLE Candidature (
    ID SERIAL PRIMARY KEY,
    EnseignantID INT NOT NULL,
    BesoinID INT NOT NULL,
    DecisionID INT,
    FOREIGN KEY (EnseignantID) REFERENCES Enseignant(ID),
    FOREIGN KEY (BesoinID) REFERENCES Besoin(ID),
    FOREIGN KEY (DecisionID) REFERENCES Decision(ID)
);