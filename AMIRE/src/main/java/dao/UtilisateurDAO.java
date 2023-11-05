package dao;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import models.Utilisateur;

import java.util.List;

@Stateless
public class UtilisateurDAO {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    @PostConstruct
    private void init() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    @PreDestroy
    private void destroy() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return em.createNamedQuery("Utilisateur.findAll", Utilisateur.class).getResultList();
    }

    public Utilisateur getUserById(int id) {

        return em.find(Utilisateur.class, id);
    }

    public void addUser(Utilisateur utilisateur) {
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
    }

    public void updateUser(Utilisateur utilisateur) {
        em.merge(utilisateur);

    }

    public void deleteUser(int id) {
        em.remove(getUserById(id));
    }

    public Utilisateur login(String mail, String password) {
        return em.createNamedQuery("Utilisateur.findByMailAndMotDePasse", Utilisateur.class)
                .setParameter("Mail", mail)
                .setParameter("MotDePasse", password)
                .getSingleResult();
    }
}