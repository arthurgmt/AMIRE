package models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Competence")
public class Competence {

    @Id
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "NomCompetence", nullable = false)
    private String NomCompetence;
    
    @ManyToMany(mappedBy = "competences")
    private Set<Enseignant> enseignants;
    
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