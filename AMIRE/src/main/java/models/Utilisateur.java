package models;


public class Utilisateur {
    private int ID;
    private String Nom;
    private String Prenom;
    private String Mail;
    private String MotDePasse;
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

