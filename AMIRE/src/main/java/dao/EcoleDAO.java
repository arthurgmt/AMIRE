package dao;

import beans.EcoleBean;
import beans.UtilisateurBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.EntityBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import models.Ecole;

import java.util.List;
@ApplicationScoped
public class EcoleDAO {
    @EJB
    private EcoleBean ecoleBean;

    public void addEcole(Ecole utilisateur) {
        ecoleBean.addEcole(utilisateur);
    }
    public void updateEcole(Ecole utilisateur) {
        ecoleBean.updateEcole(utilisateur);
    }
    public void deleteEcole(int id) {
        ecoleBean.deleteEcole(id);
    }
    public List<Ecole> getAllEcoles() {
        return ecoleBean.getAllEcoles();
    }
    public Ecole getEcoleById(int id) {
        return ecoleBean.getEcoleById(id);
    }
    public Ecole getEcoleByUtilisateurId(int id) {
        return ecoleBean.getEcoleByUtilisateurId(id);
    }
    public List<Ecole> getEcolesByNom(String nom) {return ecoleBean.getEcolesByNom(nom);}
}