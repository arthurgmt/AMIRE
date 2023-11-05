package models;

import javax.persistence.*;

@Entity
@Table(name = "Besoin")
public class Besoin {

    @Id
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "EcoleID", nullable = false)
    private int EcoleID;

    @Column(name = "Periode", nullable = false)
    private String Periode;

    @Column(name = "Remarques", columnDefinition="TEXT")
    private String Remarques;

    @Column(name = "Competences", nullable = false, columnDefinition="TEXT")
    private String Competences;

    @ManyToOne
    @JoinColumn(name = "EcoleID", insertable = false, updatable = false)
    private Ecole ecole;
    
    public Besoin(int ID, Ecole ecole, String Periode, String Remarques, String Exigences) {
        this.ID = ID;
        this.ecole = ecole;
        this.Periode = Periode;
        this.Remarques = Remarques;
        this.Competences = Exigences;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPeriode() {
        return this.Periode;
    }

    public void setPeriode(String Periode) {
        this.Periode = Periode;
    }

    public String getRemarques() {
        return this.Remarques;
    }

    public void setRemarques(String Remarques) {
        this.Remarques = Remarques;
    }

    public String getCompetences() {
        return this.Competences;
    }

    public void setCompetences(String Competences) {
        this.Competences = Competences;
    }

    public Ecole getEcole() {
        return this.ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }
}