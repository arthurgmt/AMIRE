package models;

import javax.persistence.*;

@Entity
@Table(name = "EnseignantCompetence")
public class EnseignantCompetence {

    @Id
    @ManyToOne
    @JoinColumn(name = "EnseignantID")
    private Enseignant enseignant;

    @Id
    @ManyToOne
    @JoinColumn(name = "CompetenceID")
    private Competence competence;

    public EnseignantCompetence(Enseignant enseignant, Competence competence) {
        this.enseignant = enseignant;
        this.competence = competence;
    }

    public EnseignantCompetence() {
    }
    
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