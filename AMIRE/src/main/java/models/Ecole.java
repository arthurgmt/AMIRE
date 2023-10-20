package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import java.util.List;

@Entity
public class Ecole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raisonSociale;

    @ElementCollection
    private List<String> besoins;

    @ElementCollection
    private List<String> competencesRequises;

    @ElementCollection
    private List<String> exigencesContraintes;

    private String periode;
    private String remarques;

    @ElementCollection
    private List<String> candidatsInteresses;

    public Ecole() {

    }

    // Constructeurs, getters et setters pour chaque attribut
}
