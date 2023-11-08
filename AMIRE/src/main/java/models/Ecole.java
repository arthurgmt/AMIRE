package models;

import jakarta.persistence.*;

@Entity
@Table(name = "Ecole")
@NamedQueries({
        @NamedQuery(name = "Ecole.findByUtilisateurID", query = "SELECT e FROM Ecole e WHERE e.UtilisateurID = :UtilisateurID"),
        @NamedQuery(name = "Ecole.findByNom", query = "SELECT e FROM Ecole e WHERE e.Nom LIKE :Nom")
})
public class Ecole {

    @Id
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "UtilisateurID", nullable = false)
    private int UtilisateurID;

    @Column(name = "RaisonSociale", nullable = false)
    private String RaisonSociale;

    @Column(name = "Adresse", nullable = false, columnDefinition="TEXT")
    private String Adresse;

    @Column(name = "SiteWeb")
    private String SiteWeb;

    @Column(name = "Contact")
    private String Contact;

    @Column(name = "Nom")
    private String Nom;

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUtilisateurID() {
        return this.UtilisateurID;
    }

    public void setUtilisateurID(int UtilisateurID) {
        this.UtilisateurID = UtilisateurID;
    }

    public String getRaisonSociale() {
        return this.RaisonSociale;
    }

    public void setRaisonSociale(String RaisonSociale) {
        this.RaisonSociale = RaisonSociale;
    }

    public String getAdresse() {
        return this.Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getSiteWeb() {
        return this.SiteWeb;
    }

    public void setSiteWeb(String SiteWeb) {
        this.SiteWeb = SiteWeb;
    }

    public String getContact() {
        return this.Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}