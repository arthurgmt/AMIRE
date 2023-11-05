package models;

import javax.persistence.*;

@Entity
@Table(name = "BesoinCompetence")
public class BesoinCompetence {

    @Id
    @Column(name = "BesoinID", nullable = false)
    private int BesoinID;

    @Column(name = "CompetenceID", nullable = false)
    private int CompetenceID;

    @ManyToOne
    @JoinColumn(name = "BesoinID", insertable = false, updatable = false)
    private Besoin besoin;

    @ManyToOne
    @JoinColumn(name = "CompetenceID", insertable = false, updatable = false)
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