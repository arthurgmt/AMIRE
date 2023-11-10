package models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Decision")
public class Decision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

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
}