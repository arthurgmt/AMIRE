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
        return em.createNamedQuery("Utilisateur.findAll", Enseignant.class).getResultList();
    }

    public Enseignant getEnseignantById(int id) {

        return em.find(Enseignant.class, id);
    }

    public Enseignant getEnseignantByUtilisateurId(int Userid) {
        return em.createNamedQuery("Enseignant.findByUtilisateurID", Enseignant.class)
                .setParameter("UtilisateurID", Userid)
                .getSingleResult();
    }

    public List<Enseignant> getEnseignantsByCompetence(String competence) {
        return em.createNamedQuery("Enseignant.findByCompetence", Enseignant.class)
                .setParameter("competence", competence)
                .getResultList();
    }

    public void addEnseignant(Enseignant enseignant) {
        em.getTransaction().begin();
        em.persist(enseignant);
        em.getTransaction().commit();
    }

    public void updateEnseignant(Enseignant enseignant) {
        em.merge(enseignant);

    }

    public void deleteEnseignant(int id) {
        em.remove(getEnseignantById(id));
    }
}