package models;

import javax.persistence.*;

@Entity
@Table(name = "BesoinCompetence")
public class BesoinCompetence {

    @Id
    @ManyToOne
    @JoinColumn(name = "BesoinID")
    private Besoin besoin;

    @Id
    @ManyToOne
    @JoinColumn(name = "CompetenceID")
    private Competence competence;

    public BesoinCompetence(Besoin besoin, Competence competence) {
        this.besoin = besoin;
        this.competence = competence;
    }

    public BesoinCompetence() {
    }

    public Besoin getBesoin() {
        return this.besoin;
    }

    public void setBesoin(Besoin besoin) {
        this.besoin = besoin;
    }

    public Competence getCompetence() {
        return this.competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}