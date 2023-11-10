package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Utilisateur;

import java.util.List;

@Stateless
public class UtilisateurBean {
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
        try {
            return em.createNamedQuery("Utilisateur.findAll", Utilisateur.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Utilisateur getUserById(int id) {
        try {
            return em.find(Utilisateur.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public void addUser(Utilisateur utilisateur) {
        try{
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateUser(Utilisateur utilisateur) {
        try{
            em.getTransaction().begin();
            em.merge(utilisateur);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteUser(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getUserById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Utilisateur login(String mail, String password) {
        try {
            return em.createNamedQuery("Utilisateur.findByMailAndMotDePasse", Utilisateur.class)
                    .setParameter("Mail", mail)
                    .setParameter("MotDePasse", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Utilisateur getUserByMail(String mail) {
        try {
            return em.createNamedQuery("Utilisateur.findByMail", Utilisateur.class)
                    .setParameter("Mail", mail)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
