package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Besoin;

import java.util.List;

@Stateless
public class BesoinBean {
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

    public List<Besoin> getAllBesoins() {
        try {
            return em.createNamedQuery("Besoin.findAll", Besoin.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Besoin getBesoinById(int id) {
        try{
            return em.find(Besoin.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Besoin> getBesoinsByEcoleID(int id) {
        try{
            return em.createNamedQuery("Besoin.findAllByEcoleID", Besoin.class)
                    .setParameter("EcoleID", id)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public void addBesoin(Besoin besoin) {
        try{
            em.getTransaction().begin();
            em.persist(besoin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateBesoin(Besoin besoin) {
        try{
            em.getTransaction().begin();
            em.merge(besoin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteBesoin(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getBesoinById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Besoin> getBesoinsByEcoleName(String name) {
        try{
            return em.createNamedQuery("Besoin.findAllByEcoleName", Besoin.class)
                    .setParameter("Nom", "%"+name+"%")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
