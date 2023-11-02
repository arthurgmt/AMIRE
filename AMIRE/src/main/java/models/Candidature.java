package models;

import javax.persistence.*;

@Entity
@Table(name = "Candidature")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JoinColumn(name = "EnseignantID")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "BesoinID")
    private Besoin besoin;

    @ManyToOne
    @JoinColumn(name = "DecisionID")
    private Decision decision;
    
    public Candidature(int ID, Enseignant enseignant, Besoin besoin, Decision decision) {
        this.ID = ID;
        this.enseignant = enseignant;
        this.besoin = besoin;
        this.decision = decision;
    }

    public Candidature() {
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Enseignant getEnseignant() {
        return this.enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Besoin getBesoin() {
        return this.besoin;
    }

    public void setBesoin(Besoin besoin) {
        this.besoin = besoin;
    }

    public Decision getDecision() {
        return this.decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }
}