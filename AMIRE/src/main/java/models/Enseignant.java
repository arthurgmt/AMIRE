package models;

import javax.persistence.*;
import java.util.Date;

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

    public Enseignant(int ID, Utilisateur utilisateur, int Experience, String Telephone, String SiteWeb, String NiveauxSouhaites, Date Disponibilites, String TypeContrat, String TitresAcademiques, String Evaluations, String AutresInformations) {
        this.ID = ID;
        this.utilisateur = utilisateur;
        this.Experience = Experience;
        this.Telephone = Telephone;
        this.SiteWeb = SiteWeb;
        this.NiveauxSouhaites = NiveauxSouhaites;
        this.Disponibilites = Disponibilites;
        this.TypeContrat = TypeContrat;
        this.TitresAcademiques = TitresAcademiques;
        this.Evaluations = Evaluations;
        this.AutresInformations = AutresInformations;
    }

    public Enseignant() {
    }

    public int getExperience() {
        return this.Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public String getTelephone() {
        return this.Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getSiteWeb() {
        return this.SiteWeb;
    }

    public void setSiteWeb(String SiteWeb) {
        this.SiteWeb = SiteWeb;
    }

    public String getNiveauxSouhaites() {
        return this.NiveauxSouhaites;
    }

    public void setNiveauxSouhaites(String NiveauxSouhaites) {
        this.NiveauxSouhaites = NiveauxSouhaites;
    }

    public Date getDisponibilites() {
        return this.Disponibilites;
    }

    public void setDisponibilites(Date Disponibilites) {
        this.Disponibilites = Disponibilites;
    }

    public String getTypeContrat() {
        return this.TypeContrat;
    }

    public void setTypeContrat(String TypeContrat) {
        this.TypeContrat = TypeContrat;
    }

    public String getTitresAcademiques() {
        return this.TitresAcademiques;
    }

    public void setTitresAcademiques(String TitresAcademiques) {
        this.TitresAcademiques = TitresAcademiques;
    }

    public String getEvaluations() {
        return this.Evaluations;
    }

    public void setEvaluations(String Evaluations) {
        this.Evaluations = Evaluations;
    }

    public String getAutresInformations() {
        return this.AutresInformations;
    }

    public void setAutresInformations(String AutresInformations) {
        this.AutresInformations = AutresInformations;
    }

}