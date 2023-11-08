package controllers;

import dao.EnseignantDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Enseignant;
import java.util.Date;

import java.io.IOException;

@WebServlet("/enseignant")
public class EnseignantServlet extends HttpServlet {

    @Inject
    private EnseignantDAO enseignantDAO;

    @Override
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createEnseignant(request, response);
                break;
            case "update":
                updateEnseignant(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteEnseignant(request, response);
                break;
            case "getall":
                getAllEnseignants(request, response);
                break;
            case "get":
                getEnseignant(request, response);
                break;
            case "getbycompetence":
                getEnseignantsByCompetence(request, response);
                break;

        }
    }

    private void createEnseignant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int UtilisateurID = Integer.parseInt(request.getParameter("UtilisateurID"));
        Integer experience = Integer.parseInt(request.getParameter("experience"));
        String telephone = request.getParameter("telephone");
        String siteWeb = request.getParameter("siteWeb");
        String niveauxSouhaites = request.getParameter("niveauxSouhaites");
        Date disponibilites = new Date(request.getParameter("disponibilites"));
        String typeContrat = request.getParameter("typeContrat");
        String titresAcademiques = request.getParameter("titresAcademiques");
        String evaluations = request.getParameter("evaluations");
        String autresInformations = request.getParameter("autresInformations");
        String competences = request.getParameter("competences");

        Enseignant enseignant = new Enseignant();
        enseignant.setUtilisateurID(UtilisateurID);
        enseignant.setExperience(experience);
        enseignant.setTelephone(telephone);
        enseignant.setSiteWeb(siteWeb);
        enseignant.setNiveauxSouhaites(niveauxSouhaites);
        enseignant.setDisponibilites(disponibilites);
        enseignant.setTypeContrat(typeContrat);
        enseignant.setTitresAcademiques(titresAcademiques);
        enseignant.setEvaluations(evaluations);
        enseignant.setAutresInformations(autresInformations);
        enseignant.setCompetences(competences);

        enseignantDAO.addEnseignant(enseignant);
        response.sendRedirect("login.jsp");
    }

    private void updateEnseignant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer experience = Integer.parseInt(request.getParameter("experience"));
        String telephone = request.getParameter("telephone");
        String siteWeb = request.getParameter("siteWeb");
        String niveauxSouhaites = request.getParameter("niveauxSouhaites");
        Date disponibilites = new Date(request.getParameter("disponibilites"));
        String typeContrat = request.getParameter("typeContrat");
        String titresAcademiques = request.getParameter("titresAcademiques");
        String evaluations = request.getParameter("evaluations");
        String autresInformations = request.getParameter("autresInformations");
        String competences = request.getParameter("competences");

        Enseignant enseignant = new Enseignant();
        enseignant.setExperience(experience);
        enseignant.setTelephone(telephone);
        enseignant.setSiteWeb(siteWeb);
        enseignant.setNiveauxSouhaites(niveauxSouhaites);
        enseignant.setDisponibilites(disponibilites);
        enseignant.setTypeContrat(typeContrat);
        enseignant.setTitresAcademiques(titresAcademiques);
        enseignant.setEvaluations(evaluations);
        enseignant.setAutresInformations(autresInformations);
        enseignant.setCompetences(competences);

        enseignantDAO.updateEnseignant(enseignant);
    }

    private void deleteEnseignant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        enseignantDAO.deleteEnseignant(id);
        // response.sendRedirect("users.jsp");
    }

    private void getEnseignant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Enseignant enseignant = enseignantDAO.getEnseignantById(id);
        if (enseignant != null) {
            request.setAttribute("enseignant", enseignant);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/enseignant/enseignant-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Enseignant not found");
        }
    }

    private void getAllEnseignants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("enseignants", enseignantDAO.getAllEnseignants());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/enseignant.jsp");
        dispatcher.forward(request, response);
    }

    private void getEnseignantsByCompetence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String competence = request.getParameter("competence");
        request.setAttribute("enseignants", enseignantDAO.getEnseignantsByCompetence(competence));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/enseignant.jsp");
        dispatcher.forward(request, response);
    }
}