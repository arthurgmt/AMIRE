package dao;

import beans.CandidatureBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import models.Candidature;

import java.util.List;

@ApplicationScoped
public class CandidatureDAO {
    @EJB
    private CandidatureBean candidatureBean;

    public void addCandidature(Candidature candidature) { candidatureBean.addCandidature(candidature); }

    public void updateCandidature(Candidature candidature) { candidatureBean.updateCandidature(candidature); }
    public void deleteCandidature(int id) { candidatureBean.deleteCandidature(id); }
    public java.util.List<Candidature> getAllCandidatures() { return candidatureBean.getAllCandidatures(); }
    public Candidature getCandidatureById(int id) { return candidatureBean.getCandidatureById(id); }
    public List<Candidature> getCandidaturesByEnseignantId(int id) { return candidatureBean.getCandidaturesByEnseignantId(id); }
}