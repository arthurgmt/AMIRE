package dao;

import beans.UtilisateurBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import models.Utilisateur;

import java.util.List;
@ApplicationScoped
public class UtilisateurDAO {
    @EJB
    private UtilisateurBean utilisateurBean;

    public void addUser(Utilisateur utilisateur) {
        utilisateurBean.addUser(utilisateur);
    }
    public void updateUser(Utilisateur utilisateur) {
        utilisateurBean.updateUser(utilisateur);
    }
    public void deleteUser(int id) {
        utilisateurBean.deleteUser(id);
    }
    public Utilisateur login(String mail, String password) {
        return utilisateurBean.login(mail, password);
    }
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurBean.getAllUtilisateurs();
    }
    public Utilisateur getUserById(int id) {
        return utilisateurBean.getUserById(id);
    }
    public Utilisateur getUserByMail(String mail) {
        return utilisateurBean.getUserByMail(mail);
    }

}