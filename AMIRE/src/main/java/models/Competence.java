package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Competence")
public class Competence {

    @Id
    private int ID;
    private String NomCompetence;

    @ManyToMany(mappedBy = "competences")
    private Set<Enseignant> enseignants;
    
    public Competence(int ID, String NomCompetence) {
        this.ID = ID;
        this.NomCompetence = NomCompetence;
    }

    public Competence() {
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomCompetence() {
        return this.NomCompetence;
    }

    public void setNomCompetence(String NomCompetence) {
        this.NomCompetence = NomCompetence;
    }

    public Set<Enseignant> getEnseignants() {
        return this.enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
}