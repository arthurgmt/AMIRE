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
        return em.createNamedQuery("Candidature.findAll", Candidature.class).getResultList();
    }

    public Candidature getCandidatureById(int id) {
        return em.find(Candidature.class, id);
    }

    public List<Candidature> getCandidaturesByEnseignantId(int id) {
        return em.createNamedQuery("Candidature.findAllByEnseignantID", Candidature.class)
                .setParameter("EnseignantID", id)
                .getResultList();
    }

    public void addCandidature(Candidature candidature) {
        em.getTransaction().begin();
        em.persist(candidature);
        em.getTransaction().commit();
    }

    public void updateCandidature(Candidature candidature) {
        em.merge(candidature);
    }

    public void deleteCandidature(int id) {
        em.remove(getCandidatureById(id));
    }
    public List<Candidature> getCandidaturesByCompetenceEnseignantAndBesoinID(String competence, int besoinID) {
        return em.createNamedQuery("Candidature.findAllByCompetenceEnseignantAndBesoinID", Candidature.class)
                .setParameter("Competences", "%"+competence+"%")
                .getResultList();
    }
}
