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
        return em.createNamedQuery("Utilisateur.findAll", Ecole.class).getResultList();
    }

    public Ecole getEcoleById(int id) {

        return em.find(Ecole.class, id);
    }

    public Ecole getEcoleByUtilisateurId(int Userid) {
        return em.createNamedQuery("Ecole.findByUtilisateurID", Ecole.class)
                .setParameter("UtilisateurID", Userid)
                .getSingleResult();
    }

    public void addEcole(Ecole ecole) {
        em.getTransaction().begin();
        em.persist(ecole);
        em.getTransaction().commit();
    }

    public void updateEcole(Ecole ecole) {
        em.merge(ecole);

    }

    public void deleteEcole(int id) {
        em.remove(getEcoleById(id));
    }

    public List<Ecole> getEcolesByNom(String nom) {
        return em.createNamedQuery("Ecole.findByNom", Ecole.class)
                .setParameter("nom", nom)
                .getResultList();
    }

}