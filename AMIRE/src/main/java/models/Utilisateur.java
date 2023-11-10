package models;

import jakarta.persistence.*;

@Entity
@Table(name = "Utilisateur")
@NamedQueries({
        @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
        @NamedQuery(name = "Utilisateur.findByMail", query = "SELECT u FROM Utilisateur u WHERE u.Mail = :Mail"),
        @NamedQuery(name = "Utilisateur.findByMailAndMotDePasse", query = "SELECT u FROM Utilisateur u WHERE u.Mail = :Mail AND u.MotDePasse = :MotDePasse")
})
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "Nom", nullable = false)
    private String Nom;

    @Column(name = "Prenom", nullable = false)
    private String Prenom;

    @Column(name = "Mail", nullable = false, unique = true)
    private String Mail;

    @Column(name = "MotDePasse", nullable = false)
    private String MotDePasse;

    @Column(name = "Role", nullable = false)
    private String Role;

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

