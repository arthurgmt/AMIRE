package models;

import javax.persistence.*;

@Entity
@Table(name = "Ecole")
public class Ecole {

    @Id
    private int ID;
    private String RaisonSociale;
    private String Adresse;
    private String SiteWeb;
    private String Contact;

    public Ecole(int ID, String RaisonSociale, String Adresse, String SiteWeb, String Contact) {
        this.ID = ID;
        this.RaisonSociale = RaisonSociale;
        this.Adresse = Adresse;
        this.SiteWeb = SiteWeb;
        this.Contact = Contact;
    }

    public Ecole() {
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
}