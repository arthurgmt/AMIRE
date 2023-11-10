package controllers;

import dao.DecisionDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Decision;

import java.io.IOException;
import java.util.Date;

@WebServlet("/decision")
public class DecisionServlet  extends HttpServlet {
    @Inject
    DecisionDAO decisionDAO;

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
        }
    }

    private void createDecision(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int CandidatureID = Integer.parseInt(request.getParameter("CandidatureID"));
        String Status = request.getParameter("Status");
        String Commentaires = request.getParameter("Commentaires");

        Decision decision = new Decision();
        decision.setCandidatureID(CandidatureID);
        decision.setDateDecision(new Date());
        decision.setCommentaires(Commentaires);
        decision.setStatut(Status);

        decisionDAO.addDecision(decision);
        // response.sendRedirect("ecole.jsp");
    }

    private void updateDecision(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Status = request.getParameter("Status");
        String Commentaires = request.getParameter("Commentaires");

        Decision decision = new Decision();
        decision.setDateDecision(new Date());
        decision.setCommentaires(Commentaires);
        decision.setStatut(Status);

        decisionDAO.updateDecision(decision);
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

    private void getAllDecision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", decisionDAO.getAllDecisions());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }
}
