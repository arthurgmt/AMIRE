package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Enseignant")
public class Enseignant {

    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "UtilisateurID", nullable = false)
    private int UtilisateurID;

    @Column(name = "Experience")
    private Integer Experience;

    @Column(name = "Telephone", nullable = false)
    private String Telephone;

    @Column(name = "SiteWeb")
    private String SiteWeb;

    @Column(name = "NiveauxSouhaites")
    private String NiveauxSouhaites;

    @Column(name = "Disponibilites", nullable = false)
    private Date Disponibilites;

    @Column(name = "TypeContrat")
    private String TypeContrat;

    @Column(name = "TitresAcademiques", columnDefinition="TEXT")
    private String TitresAcademiques;

    @Column(name = "Evaluations", columnDefinition="TEXT")
    private String Evaluations;

    @Column(name = "AutresInformations", columnDefinition="TEXT")
    private String AutresInformations;

    @Column(name = "Competences", columnDefinition = "TEXT", nullable = false)
    private String Competences;

    @OneToOne
    @JoinColumn(name = "UtilisateurID", insertable = false, updatable = false)
    private Utilisateur utilisateur;


    public Enseignant(int UtilisateurID, int Experience, String Telephone, String SiteWeb, String NiveauxSouhaites, Date Disponibilites, String TypeContrat, String TitresAcademiques, String Evaluations, String AutresInformations,  Utilisateur utilisateur, String Competences) {
        this.UtilisateurID = UtilisateurID;
        this.Experience = Experience;
        this.Telephone = Telephone;
        this.SiteWeb = SiteWeb;
        this.NiveauxSouhaites = NiveauxSouhaites;
        this.Disponibilites = Disponibilites;
        this.TypeContrat = TypeContrat;
        this.TitresAcademiques = TitresAcademiques;
        this.Evaluations = Evaluations;
        this.AutresInformations = AutresInformations;
        this.utilisateur = utilisateur;
        this.Competences = Competences;
    }

    public Enseignant(int ID, int UtilisateurID, int Experience, String Telephone, String SiteWeb, String NiveauxSouhaites, Date Disponibilites, String TypeContrat, String TitresAcademiques, String Evaluations, String AutresInformations, String Competences) {
        this.ID = ID;
        this.UtilisateurID = UtilisateurID;
        this.Experience = Experience;
        this.Telephone = Telephone;
        this.SiteWeb = SiteWeb;
        this.NiveauxSouhaites = NiveauxSouhaites;
        this.Disponibilites = Disponibilites;
        this.TypeContrat = TypeContrat;
        this.TitresAcademiques = TitresAcademiques;
        this.Evaluations = Evaluations;
        this.AutresInformations = AutresInformations;
        this.Competences = Competences;
    }

    public Enseignant(int UtilisateurID, int Experience, String Telephone, String SiteWeb, String NiveauxSouhaites, Date Disponibilites, String TypeContrat, String TitresAcademiques, String Evaluations, String AutresInformations, String Competences) {
        this.UtilisateurID = UtilisateurID;
        this.Experience = Experience;
        this.Telephone = Telephone;
        this.SiteWeb = SiteWeb;
        this.NiveauxSouhaites = NiveauxSouhaites;
        this.Disponibilites = Disponibilites;
        this.TypeContrat = TypeContrat;
        this.TitresAcademiques = TitresAcademiques;
        this.Evaluations = Evaluations;
        this.AutresInformations = AutresInformations;
        this.Competences = Competences;
    }

    public Enseignant() {
    }

    public int getID() {
        return this.ID;
    }

    public int getUtilisateurID() {
        return this.UtilisateurID;
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

    public String getCompetences() {
        return Competences;
    }

    public void setCompetences(String competences) {
        Competences = competences;
    }
}