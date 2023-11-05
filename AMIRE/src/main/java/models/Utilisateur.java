package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.ManyToOne;
// import javax.persistence.JoinColumn;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "Nom", nullable = false)
    private String Nom;

    @Column(name = "Prenom", nullable = false)
    private String Prenom;

    @Column(name = "Mail", nullable = false)
    private String Mail;

    @Column(name = "MotDePasse", nullable = false)
    private String MotDePasse;

    @Column(name = "Role", nullable = false)
    private String Role;

    public Utilisateur(int ID, String Nom, String Prenom, String Mail, String MotDePasse, String Role) {
        this.ID = ID;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Mail = Mail;
        this.MotDePasse = MotDePasse;
        this.Role = Role;
    }

    public Utilisateur() {
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return this.Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return this.Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getMail() {
        return this.Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getMotDePasse() {
        return this.MotDePasse;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
}

