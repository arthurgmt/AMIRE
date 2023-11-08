package dao;

import beans.EnseignantBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import models.Enseignant;

import java.util.List;
@ApplicationScoped
public class EnseignantDAO {
    @EJB
    private EnseignantBean enseignantBean;

    public void addEnseignant(Enseignant utilisateur) {
        enseignantBean.addEnseignant(utilisateur);
    }
    public void updateEnseignant(Enseignant utilisateur) {
        enseignantBean.updateEnseignant(utilisateur);
    }
    public void deleteEnseignant(int id) {
        enseignantBean.deleteEnseignant(id);
    }
    public List<Enseignant> getAllEnseignants() {
        return enseignantBean.getAllEnseignants();
    }
    public Enseignant getEnseignantById(int id) {
        return enseignantBean.getEnseignantById(id);
    }
    public Enseignant getEnseignantByUtilisateurId(int id) {
        return enseignantBean.getEnseignantByUtilisateurId(id);
    }
    public List<Enseignant> getEnseignantsByCompetence(String competence) {return enseignantBean.getEnseignantsByCompetence(competence);}
}