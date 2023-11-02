package models;

import javax.persistence.*;
import java.util.Date;
// import java.util.Set;

@Entity
@Table(name = "Enseignant")
public class Enseignant {

    @Id
    private int ID;

    @OneToOne
    @JoinColumn(name = "UtilisateurID", referencedColumnName = "ID")
    private Utilisateur utilisateur;

    private int Experience;
    private String Telephone;
    private String SiteWeb;
    private String NiveauxSouhaites;
    private Date Disponibilites;
    private String TypeContrat;
    private String TitresAcademiques;
    private String Evaluations;
    private String AutresInformations;

    // Getters, Setters, Constructors...
}