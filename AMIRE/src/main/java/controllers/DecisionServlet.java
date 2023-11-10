package controllers;

import dao.CandidatureDAO;
import dao.DecisionDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Candidature;
import models.Decision;

import java.io.IOException;
import java.util.Date;

@WebServlet("/decision")
public class DecisionServlet  extends HttpServlet {
    @Inject
    DecisionDAO decisionDAO;
    @Inject
    CandidatureDAO candidatureDAO;

    @Override
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createDecision(request, response);
                break;
            case "update":
                updateDecision(request, response);
                break;
            case "beforecreate":
                beforeCreate(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteDecision(request, response);
                break;
            case "getall":
                getAllDecision(request, response);
                break;
            case "get":
                getDecision(request, response);
                break;
            case "getbycandidature":
                getDecisionByCandidature(request, response);
                break;
            case "getbybesoin":
                getDecisionsByBesoin(request, response);
                break;
            case "beforecreate":
                request.setAttribute("candiID", request.getParameter("candiID"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/CreateDecision.jsp");
                dispatcher.forward(request, response);
                break;
        }
    }

    private void beforeCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("candiID", request.getParameter("candiID"));
        request.setAttribute("besoinID", request.getParameter("besoinID"));
        Decision decision = decisionDAO.getDecisionByCandidatureId(Integer.parseInt(request.getParameter("candiID")));
        if (decision != null) {
            request.setAttribute("decision", decision);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CreateDecision.jsp");
        dispatcher.forward(request, response);
    }

    private void createDecision(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int CandidatureID = Integer.parseInt(request.getParameter("candiID"));
        String Status = request.getParameter("status");
        String Commentaires = request.getParameter("commentaire");

        Decision decision = new Decision();
        if (CandidatureID >= 0) decision.setCandidatureID(CandidatureID);
        decision.setDateDecision(new Date());
        if (Commentaires != null)decision.setCommentaires(Commentaires);
        if (Status != null) decision.setStatut(Status);

        decisionDAO.addDecision(decision);
        Candidature candidature = candidatureDAO.getCandidatureById(CandidatureID);
        request.getRequestDispatcher("candidature?action=getbybesoinid&id=" + candidature.getBesoinID()).forward(request, response);
    }

    private void updateDecision(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int ID = Integer.parseInt(request.getParameter("besoinID"));
        String Status = request.getParameter("statuss");
        String Commentaires = request.getParameter("commentaires");

        Decision decision = decisionDAO.getDecisionById(ID);
        if (decision == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Decision not found");
            return;
        }
        decision.setDateDecision(new Date());
        if (Commentaires != null) decision.setCommentaires(Commentaires);
        if (Status != null) decision.setStatut(Status);

        decisionDAO.updateDecision(decision);
        response.sendRedirect(request.getContextPath() + "candidature?action=getbybesoinid&id=" + ID);
    }

    private void deleteDecision(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        decisionDAO.deleteDecision(id);
        // response.sendRedirect("users.jsp");
    }

    private void getDecision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Decision decision = decisionDAO.getDecisionById(id);
        if (decision != null) {
            request.setAttribute("user", decision);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Decision not found");
        }
    }

    private void getDecisionByCandidature(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Decision decision = decisionDAO.getDecisionByCandidatureId(id);
        if (decision != null) {
            request.setAttribute("decision", decision);
            RequestDispatcher dispatcher = request.getRequestDispatcher("DecisionInfo.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Decision not found");
        }
    }

    private void getDecisionsByBesoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int besoinID = Integer.parseInt(request.getParameter("besoinID"));
        request.setAttribute("enseignants", decisionDAO.getDecisionsByBesoinId(besoinID));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/enseignant.jsp");
        dispatcher.forward(request, response);
    }

    private void getAllDecision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", decisionDAO.getAllDecisions());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }
}
