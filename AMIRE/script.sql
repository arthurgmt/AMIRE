CREATE DATABASE Amire;
USE Amire;
CREATE TABLE Enseignant (
    ID INT PRIMARY KEY,
    Nom VARCHAR(255),
    Prenom VARCHAR(255),
    Experience INT,
    Mail VARCHAR(255),
    Telephone VARCHAR(20),
    SiteWeb VARCHAR(255),
    NiveauxSouhaites VARCHAR(255),
    Disponibilites DATE,
    TypeContrat VARCHAR(50),
    TitresAcademiques TEXT,
    Evaluations TEXT,
    AutresInformations TEXT
);
CREATE TABLE Ecole (
    ID INT PRIMARY KEY,
    RaisonSociale VARCHAR(255),
    Adresse TEXT,
    SiteWeb VARCHAR(255),
    Contact VARCHAR(255)
);
CREATE TABLE Besoin (
    ID INT PRIMARY KEY,
    EcoleID INT,
    Periode VARCHAR(255),
    Remarques TEXT,
    Exigences TEXT,
    FOREIGN KEY (EcoleID) REFERENCES Ecole(ID)
);
CREATE TABLE Candidature (
     ID INT AUTO_INCREMENT PRIMARY KEY,
     EnseignantID INT,
     BesoinID INT,
     DecisionID INT,
     FOREIGN KEY (EnseignantID) REFERENCES Enseignant(ID),
     FOREIGN KEY (BesoinID) REFERENCES Besoin(ID),
     FOREIGN KEY (DecisionID) REFERENCES Decision(ID)
);
CREATE TABLE Decision (
    ID INT PRIMARY KEY,
    Statut VARCHAR(50),
    DateDecision DATE,
    Commentaires TEXT
);
CREATE TABLE Competence (
    ID INT PRIMARY KEY,
    NomCompetence VARCHAR(255)
);
CREATE TABLE BesoinCompetence (
    BesoinID INT,
    CompetenceID INT,
    PRIMARY KEY (BesoinID, CompetenceID),
    FOREIGN KEY (BesoinID) REFERENCES Besoin(ID),
    FOREIGN KEY (CompetenceID) REFERENCES Competence(ID)
);
CREATE TABLE EnseignantCompetence (
    EnseignantID INT,
    CompetenceID INT,
    PRIMARY KEY (EnseignantID, CompetenceID),
    FOREIGN KEY (EnseignantID) REFERENCES Enseignant(ID),
    FOREIGN KEY (CompetenceID) REFERENCES Competence(ID)
);