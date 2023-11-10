package dao;

import beans.DecisionBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import models.Candidature;
import models.Decision;

import java.util.List;

@ApplicationScoped
public class DecisionDAO {
    @EJB
    private DecisionBean decisionBean;

    public void addDecision(Decision decision) { decisionBean.addDecision(decision); }

    public void updateDecision(Decision decision) { decisionBean.updateDecision(decision); }
    public void deleteDecision(int id) { decisionBean.deleteDecision(id); }
    public java.util.List<Decision> getAllDecisions() { return decisionBean.getAllDecisions(); }
    public Decision getDecisionById(int id) { return decisionBean.getDecisionById(id); }
    public Decision getDecisionByCandidatureId(int CandidatureID) { return decisionBean.getDecisionByCandidatureId(CandidatureID); }
    public List<Decision> getDecisionsByBesoinId(int BesoinID) { return decisionBean.getDecisionsByBesoinId(BesoinID); }
}
