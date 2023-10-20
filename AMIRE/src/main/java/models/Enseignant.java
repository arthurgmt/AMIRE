package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import java.util.List;

@Entity
public class Enseignant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private String experience;

    @ElementCollection
    private List<String> evaluations;

    @ElementCollection
    private List<String> competences;
    
    @ElementCollection
    private List<String> interetsDomaines;

    @ElementCollection
    private List<String> interetsEcoles;
    
    @ElementCollection
    private List<String> niveauxSouhaites;

    private String adresseElectronique;
    private String telephone;
    private String siteWeb;
    private String disponibilites;
    private String typeDeContrat;

    @ElementCollection
    private List<String> titresAcademiques;

    private String autresInformations;

    @ElementCollection
    private List<String> references;

    private String candidatures;

    // Constructeurs, getters et setters pour chaque attribut
}
