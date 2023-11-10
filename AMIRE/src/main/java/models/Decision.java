package models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Decision")
@NamedQueries({
        @NamedQuery(name = "Decision.findAll", query = "SELECT d FROM Decision d"),
        @NamedQuery(name = "Decision.findByCandidatureID", query = "SELECT d FROM Decision d WHERE d.CandidatureID = :CandidatureID"),
})
public class Decision {

    @Id
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "CandidatureID", nullable = false)
    private int CandidatureID;

    @OneToOne
    @JoinColumn(name = "CandidatureID", insertable = false, updatable = false)
    private Candidature candidature;

    @Column(name = "Statut", nullable = false)
    private String Statut;

    @Column(name = "DateDecision", nullable = false)
    private Date DateDecision;

    @Column(name = "Commentaires", columnDefinition="TEXT")
    private String Commentaires;

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStatut() {
        return this.Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public Date getDateDecision() {
        return this.DateDecision;
    }

    public void setDateDecision(Date DateDecision) {
        this.DateDecision = DateDecision;
    }

    public String getCommentaires() {
        return this.Commentaires;
    }

    public void setCommentaires(String Commentaires) {
        this.Commentaires = Commentaires;
    }

    public int getCandidatureID() {
        return CandidatureID;
    }

    public void setCandidatureID(int candidatureID) {
        CandidatureID = candidatureID;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }
}