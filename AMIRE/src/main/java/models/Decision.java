package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Decision")
public class Decision {

    @Id
    private int ID;
    private String Statut;
    private Date DateDecision;
    private String Commentaires;

    public Decision(int ID, String Statut, Date DateDecision, String Commentaires) {
        this.ID = ID;
        this.Statut = Statut;
        this.DateDecision = DateDecision;
        this.Commentaires = Commentaires;
    }

    public Decision() {
    }

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