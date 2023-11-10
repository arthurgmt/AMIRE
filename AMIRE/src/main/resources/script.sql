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
    Nom VARCHAR(255) NOT NULL,
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(ID)
);
CREATE TABLE Besoin (
    ID SERIAL PRIMARY KEY,
    EcoleID INT NOT NULL,
    Periode VARCHAR(255) NOT NULL,
    Remarques TEXT,
    Competences TEXT NOT NULL,
    FOREIGN KEY (EcoleID) REFERENCES Ecole(ID)
);
CREATE TABLE Candidature (
    ID SERIAL PRIMARY KEY,
    EnseignantID INT NOT NULL,
    BesoinID INT NOT NULL,
    FOREIGN KEY (EnseignantID) REFERENCES Enseignant(ID),
    FOREIGN KEY (BesoinID) REFERENCES Besoin(ID),
    UNIQUE (EnseignantID, BesoinID)
);
CREATE TABLE Decision (
                          ID SERIAL PRIMARY KEY,
                          CandidatureID INT NOT NULL,
                          Statut VARCHAR(50) NOT NULL,
                          DateDecision DATE NOT NULL,
                          Commentaires TEXT,
                          FOREIGN KEY (CandidatureID) REFERENCES Candidature(ID),
                          UNIQUE (CandidatureID)
);
INSERT INTO Utilisateur (Nom, Prenom, Mail, MotDePasse, Role) VALUES ('admin', 'admin', 'root@mail.fr', 'root', 'Admin');
INSERT INTO Utilisateur (Nom, Prenom, Mail, MotDePasse, Role) VALUES
('EnseignantNom', 'EnseignantPrenom', 'enseignant@example.com', 'motDePasseEnseignant', 'Enseignant'),
('RecruteurNom', 'RecruteurPrenom', 'recruteur@example.com', 'motDePasseRecruteur', 'Recruteur');

INSERT INTO Enseignant (UtilisateurID, Experience, Telephone, SiteWeb, NiveauxSouhaites, Disponibilites, TypeContrat, TitresAcademiques, Evaluations, AutresInformations, Competences) VALUES
                                                                                                                                                                                           (1, 5, '123456789', 'www.enseignant1.com', 'Niveaux1, Niveaux2', '2023-01-01', 'CDI', 'Licence Informatique', 'Evaluations1', 'Autres Informations1', 'Java, Python'),
                                                                                                                                                                                           (2, 3, '987654321', 'www.enseignant2.com', 'Niveaux3, Niveaux4', '2023-02-01', 'CDD', 'Master Informatique', 'Evaluations2', 'Autres Informations2', 'C++, SQL');
INSERT INTO Ecole (UtilisateurID, RaisonSociale, Adresse, SiteWeb, Contact, Nom) VALUES
(2, 'Ecole1 Raison Sociale', 'Adresse Ecole 1', 'www.ecole1.com', 'Contact Ecole 1', 'Ecole1 Nom'),
(3, 'Ecole2 Raison Sociale', 'Adresse Ecole 2', 'www.ecole2.com', 'Contact Ecole 2', 'Ecole2 Nom');

INSERT INTO Besoin (EcoleID, Periode, Remarques, Competences) VALUES
(1, '2023-03-01', 'Remarques Besoin 1', 'Java, Python'),
(2, '2023-04-01', 'Remarques Besoin 2', 'C++, SQL');

INSERT INTO Candidature (EnseignantID, BesoinID) VALUES
(1, 1),
(2, 2);