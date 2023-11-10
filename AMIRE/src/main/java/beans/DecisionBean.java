package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Decision;

import java.util.List;

@Stateless

public class DecisionBean {
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

    public List<Decision> getAllDecisions() {
        try{
            return em.createNamedQuery("Decision.findAll", Decision.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Decision getDecisionById(int id) {
        try{
            return em.find(Decision.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public Decision getDecisionByCandidatureId(int CandidatureID) {
        try{
            return em.createNamedQuery("Decision.findByCandidatureID", Decision.class)
                    .setParameter("CandidatureID", CandidatureID)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Decision> getDecisionsByBesoinId(int BesoinID) {
        try{
            return em.createNamedQuery("Decision.findAllByBesoinID", Decision.class)
                    .setParameter("BesoinID", BesoinID)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public void addDecision(Decision decision) {
        try{
            em.getTransaction().begin();
            em.persist(decision);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateDecision(Decision decision) {
        try{
            em.getTransaction().begin();
            em.merge(decision);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteDecision(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getDecisionById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
