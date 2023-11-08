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
        return em.createNamedQuery("Besoin.findAll", Besoin.class).getResultList();
    }

    public Besoin getBesoinById(int id) {
        return em.find(Besoin.class, id);
    }

    public List<Besoin> getBesoinsByEcoleID(int id) {
        return em.createNamedQuery("Besoin.findAllByEcoleID", Besoin.class)
                .setParameter("EcoleID", id)
                .getResultList();
    }

    public void addBesoin(Besoin besoin) {
        em.getTransaction().begin();
        em.persist(besoin);
        em.getTransaction().commit();
    }

    public void updateBesoin(Besoin besoin) {
        em.merge(besoin);
    }

    public void deleteBesoin(int id) {
        em.remove(getBesoinById(id));
    }

    public List<Besoin> getBesoinsByEcoleName(String name) {
        return em.createNamedQuery("Besoin.findAllByEcoleName", Besoin.class)
                .setParameter("Nom", "%"+name+"%")
                .getResultList();
    }
}
