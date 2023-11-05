package models;

import jakarta.persistence.*;

@Entity
@Table(name = "EnseignantCompetence")
public class EnseignantCompetence {

    @Id
    @Column(name = "EnseignantID", nullable = false)
    private int EnseignantID;

    @Column(name = "CompetenceID", nullable = false)
    private int CompetenceID;

    @ManyToOne
    @JoinColumn(name = "EnseignantID", insertable = false, updatable = false)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "CompetenceID", insertable = false, updatable = false)
    private Competence competence;
    
    public Enseignant getEnseignant() {
        return this.enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Competence getCompetence() {
        return this.competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}