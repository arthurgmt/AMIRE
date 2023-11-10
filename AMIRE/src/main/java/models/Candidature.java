package models;

import jakarta.persistence.*;


@Entity
@Table(name = "Candidature")
@NamedQueries({
        @NamedQuery(name = "Candidature.findAll", query = "SELECT c FROM Candidature c"),
        @NamedQuery(name = "Candidature.findAllByEnseignantID", query = "SELECT c FROM Candidature c WHERE c.EnseignantID = :EnseignantID"),
        @NamedQuery(name = "Candidature.findAllByCompetenceEnseignantAndBesoinID", query = "SELECT c FROM Candidature c WHERE c.BesoinID = :besoinID AND c.EnseignantID = (SELECT e.ID FROM Enseignant e WHERE e.Competences LIKE :Competences)")
})
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "EnseignantID", nullable = false)
    private int EnseignantID;

    @Column(name = "BesoinID", nullable = false)
    private int BesoinID;

    @ManyToOne
    @JoinColumn(name = "EnseignantID", insertable = false, updatable = false)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "BesoinID", insertable = false, updatable = false)
    private Besoin besoin;

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

    public int getEnseignantID() {
        return EnseignantID;
    }

    public void setEnseignantID(int enseignantID) {
        EnseignantID = enseignantID;
    }

    public int getBesoinID() {
        return BesoinID;
    }

    public void setBesoinID(int besoinID) {
        BesoinID = besoinID;
    }
}