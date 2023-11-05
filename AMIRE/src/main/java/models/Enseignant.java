package models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Enseignant")
public class Enseignant {

    @Id
    @Column(name = "ID", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "UtilisateurID", insertable = false, updatable = false)
    private Utilisateur utilisateur;

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