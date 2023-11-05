package models;

import javax.persistence.*;

@Entity
@Table(name = "Candidature")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "EnseignantID", nullable = false)
    private int EnseignantID;

    @Column(name = "BesoinID", nullable = false)
    private int BesoinID;

    @Column(name = "DecisionID", nullable = false)
    private int DecisionID;

    @ManyToOne
    @JoinColumn(name = "EnseignantID", insertable = false, updatable = false)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "BesoinID", insertable = false, updatable = false)
    private Besoin besoin;

    @ManyToOne
    @JoinColumn(name = "DecisionID", insertable = false, updatable = false)
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