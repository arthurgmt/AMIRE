package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Enseignant;
import java.util.List;

@Stateless
public class EnseignantBean {
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

    public List<Enseignant> getAllEnseignants() {
        try{
            return em.createNamedQuery("Enseignant.findAll", Enseignant.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Enseignant getEnseignantById(int id) {
        try{
            return em.find(Enseignant.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public Enseignant getEnseignantByUtilisateurId(int Userid) {
        try{
            return em.createNamedQuery("Enseignant.findByUtilisateurID", Enseignant.class)
                    .setParameter("UtilisateurID", Userid)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Enseignant> getEnseignantsByCompetence(String competence) {
        try{
            return em.createNamedQuery("Enseignant.findByCompetence", Enseignant.class)
                    .setParameter("Competences","%"+competence+"%")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public void addEnseignant(Enseignant enseignant) {
        try{
            em.getTransaction().begin();
            em.persist(enseignant);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateEnseignant(Enseignant enseignant) {
        try{
            em.getTransaction().begin();
            em.merge(enseignant);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteEnseignant(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getEnseignantById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}