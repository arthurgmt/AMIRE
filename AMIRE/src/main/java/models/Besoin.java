package models;

import javax.persistence.*;

@Entity
@Table(name = "Besoin")
public class Besoin {

    @Id
    private int ID;

    @ManyToOne
    @JoinColumn(name = "EcoleID")
    private Ecole ecole;

    private String Periode;
    private String Remarques;
    private String Exigences;
    
    public Besoin(int ID, Ecole ecole, String Periode, String Remarques, String Exigences) {
        this.ID = ID;
        this.ecole = ecole;
        this.Periode = Periode;
        this.Remarques = Remarques;
        this.Exigences = Exigences;
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

    public String getExigences() {
        return this.Exigences;
    }

    public void setExigences(String Exigences) {
        this.Exigences = Exigences;
    }

    public Ecole getEcole() {
        return this.ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }
}