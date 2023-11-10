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
import java.util.List;

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
            case "delete":
                deleteCandidature(request, response);
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
            case "getbyenseignant":
                request.setAttribute("candidatures", getCandidatureByEnseignant(request, response));
                request.getRequestDispatcher("/ListeCandidature.jsp").forward(request, response);
                break;
            case "getbycompetenceandbesoinid":
                getCandidatureByCompetenceAndBesoinID(request, response);
                break;
            case "getbybesoinid":
                request.setAttribute("besoinID", request.getParameter("id"));
                request.setAttribute("candidatures", candidatureDAO.getCandidaturesByBesoinID(Integer.parseInt(request.getParameter("id"))));
                request.getRequestDispatcher("/listCandidature.jsp").forward(request, response);
                break;
        }
    }

    private void createCandidature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int EnseignantID = Integer.parseInt(request.getParameter("EnseignantID"));
        int BesoinID = Integer.parseInt(request.getParameter("BesoinID"));

        Candidature candidature = new Candidature();
        if (EnseignantID >= 0) candidature.setEnseignantID(EnseignantID);
        if (BesoinID >= 0) candidature.setBesoinID(BesoinID);

        candidatureDAO.addCandidature(candidature);
        response.sendRedirect(request.getContextPath() + "/besoin?action=listEnseignantBesoin");
    }

    private void updateCandidature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        int EnseignantID = Integer.parseInt(request.getParameter("EnseignantID"));
        int BesoinID = Integer.parseInt(request.getParameter("BesoinID"));

        Candidature candidature = candidatureDAO.getCandidatureById(ID);
         if (candidature == null) {
             response.sendError(HttpServletResponse.SC_NOT_FOUND, "candidature not found");
             return;
         }

        if (EnseignantID >= 0) candidature.setEnseignantID(EnseignantID);
        if (BesoinID >= 0) candidature.setBesoinID(BesoinID);

        candidatureDAO.updateCandidature(candidature);
    }

    private void deleteCandidature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("ID"));
        int EnseignantID = Integer.parseInt(request.getParameter("EnseignantID"));
        candidatureDAO.deleteCandidature(id);
        response.sendRedirect(request.getContextPath() + "/candidature?action=getbyenseignant&id=" + EnseignantID);
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

    private List<Candidature> getCandidatureByEnseignant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        return candidatureDAO.getCandidaturesByEnseignantId(id);
    }

    private void getCandidatureByCompetenceAndBesoinID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int besoinID = Integer.parseInt(request.getParameter("besoinID"));
        String competence = request.getParameter("competence");
        request.setAttribute("candidatures", candidatureDAO.getCandidaturesByCompetenceEnseignantAndBesoinID(competence, besoinID));
        request.setAttribute("recherche", competence);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listCandidature.jsp");
        dispatcher.forward(request, response);
    }
}
