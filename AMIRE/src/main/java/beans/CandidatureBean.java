package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Candidature;

import java.util.List;

@Stateless
public class CandidatureBean {
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

    public List<Candidature> getAllCandidatures() {
        try{
            return em.createNamedQuery("Candidature.findAll", Candidature.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Candidature getCandidatureById(int id) {
        try{
            return em.find(Candidature.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Candidature> getCandidaturesByEnseignantId(int id) {
        try{
            return em.createNamedQuery("Candidature.findAllByEnseignantID", Candidature.class)
                    .setParameter("EnseignantID", id)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public void addCandidature(Candidature candidature) {
        try{
            em.getTransaction().begin();
            em.persist(candidature);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateCandidature(Candidature candidature) {
        try{
            em.getTransaction().begin();
            em.merge(candidature);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteCandidature(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getCandidatureById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public List<Candidature> getCandidaturesByCompetenceEnseignantAndBesoinID(String competence, int besoinID) {
        try{
            return em.createNamedQuery("Candidature.findAllByCompetenceEnseignantAndBesoinID", Candidature.class)
                    .setParameter("Competences", "%"+competence+"%")
                    .setParameter("besoinID", besoinID)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Candidature> getCandidaturesByBesoinID(int besoinID) {
        try{
            return em.createNamedQuery("Candidature.findAllByBesoinID", Candidature.class)
                    .setParameter("BesoinID", besoinID)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
