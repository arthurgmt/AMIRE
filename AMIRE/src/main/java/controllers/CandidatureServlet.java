package controllers;

import dao.CandidatureDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Candidature;
import models.Ecole;

import java.io.IOException;

@WebServlet("/candidature")
public class CandidatureServlet extends HttpServlet {
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
                createCandidature(request, response);
                break;
            case "update":
                updateCandidature(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteCandidature(request, response);
                break;
            case "getall":
                getAllCandidature(request, response);
                break;
            case "get":
                getCandidature(request, response);
                break;
        }
    }

    private void createCandidature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int EnseignantID = Integer.parseInt(request.getParameter("EnseignantID"));
        int BesoinID = Integer.parseInt(request.getParameter("BesoinID"));

        Candidature candidature = new Candidature();
        candidature.setEnseignantID(EnseignantID);
        candidature.setBesoinID(BesoinID);

        candidatureDAO.addCandidature(candidature);
        // response.sendRedirect("ecole.jsp");
    }

    private void updateCandidature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int EnseignantID = Integer.parseInt(request.getParameter("EnseignantID"));
        int BesoinID = Integer.parseInt(request.getParameter("BesoinID"));
        int DecisionID = Integer.parseInt(request.getParameter("DecisionID"));

        Candidature candidature = new Candidature();
        candidature.setEnseignantID(EnseignantID);
        candidature.setBesoinID(BesoinID);

        candidatureDAO.updateCandidature(candidature);
    }

    private void deleteCandidature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        candidatureDAO.deleteCandidature(id);
        // response.sendRedirect("users.jsp");
    }

    private void getCandidature(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Candidature candidature = candidatureDAO.getCandidatureById(id);
        if (candidature != null) {
            request.setAttribute("user", candidature);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "candidature not found");
        }
    }

    private void getAllCandidature(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", candidatureDAO.getAllCandidatures());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }

    private void getCandidatureByEnseignant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("users", candidatureDAO.getCandidaturesByEnseignantId(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }

    private void getCandidatureByCompetenceAndBesoinID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int besoinID = Integer.parseInt(request.getParameter("besoinID"));
        String competence = request.getParameter("competence");
        request.setAttribute("users", candidatureDAO.getCandidaturesByCompetenceEnseignantAndBesoinID(competence, besoinID));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }
}
