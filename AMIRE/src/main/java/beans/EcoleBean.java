package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Ecole;

import java.util.List;

@Stateless
public class EcoleBean {
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

    public List<Ecole> getAllEcoles() {
        try{
            return em.createNamedQuery("Ecole.findAll", Ecole.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Ecole getEcoleById(int id) {
        try {
            return em.find(Ecole.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public Ecole getEcoleByUtilisateurId(int Userid) {
        try{
            return em.createNamedQuery("Ecole.findByUtilisateurID", Ecole.class)
                    .setParameter("UtilisateurID", Userid)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void addEcole(Ecole ecole) {
        try{
            em.getTransaction().begin();
            em.persist(ecole);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateEcole(Ecole ecole) {
        try {
            em.getTransaction().begin();
            em.merge(ecole);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteEcole(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getEcoleById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Ecole> getEcolesByNom(String nom) {
        try {
            return em.createNamedQuery("Ecole.findByNom", Ecole.class)
                    .setParameter("Nom", "%"+nom+"%")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}