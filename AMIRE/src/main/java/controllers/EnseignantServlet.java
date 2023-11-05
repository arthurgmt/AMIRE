package controllers;

import dao.EnseignantDAO;
import models.Enseignant;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.sql.Date;

@WebServlet("/enseignant")
public class EnseignantServlet extends HttpServlet {

    private EnseignantDAO enseignantDAO;

    @Override
    public void init() {
        enseignantDAO = new EnseignantDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not specified");
            return;
        }

        switch (action) {
            case "register":
                addEnseignant(request, response);
                break;
            case "update":
                updateEnseignant(request, response);
                break;
            case "login":
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Action not handled");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not specified");
            return;
        }

        switch (action) {
            case "delete":
                deleteEnseignant(request, response);
                break;
            case "get":
                getEnseignant(request, response);
                break;
            case "list":
                listEnseignants(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Action not handled");
                break;
        }
    }

    private void addEnseignant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int utilisateurID = Integer.parseInt(request.getParameter("utilisateurID"));
            int experience = Integer.parseInt(request.getParameter("experience"));
            String telephone = request.getParameter("telephone");
            String siteWeb = request.getParameter("siteWeb");
            String niveauxSouhaites = request.getParameter("niveauxSouhaites");
            Date disponibilites = Date.valueOf(request.getParameter("disponibilites"));
            String typeContrat = request.getParameter("typeContrat");
            String titresAcademiques = request.getParameter("titresAcademiques");
            String evaluations = request.getParameter("evaluations");
            String autresInformations = request.getParameter("autresInformations");
    
            Enseignant newEnseignant = new Enseignant(
                    utilisateurID,
                    experience,
                    telephone,
                    siteWeb,
                    niveauxSouhaites,
                    disponibilites,
                    typeContrat,
                    titresAcademiques,
                    evaluations,
                    autresInformations
            );
    
            enseignantDAO.addEnseignant(newEnseignant);
            response.sendRedirect("enseignants.jsp"); // Rediriger vers la liste des enseignants
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erreur lors de l'ajout de l'enseignant.");
        }
    }
    

    private void updateEnseignant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int utilisateurID = Integer.parseInt(request.getParameter("utilisateurID"));
            int experience = Integer.parseInt(request.getParameter("experience"));
            String telephone = request.getParameter("telephone");
            String siteWeb = request.getParameter("siteWeb");
            String niveauxSouhaites = request.getParameter("niveauxSouhaites");
            Date disponibilites = Date.valueOf(request.getParameter("disponibilites"));
            String typeContrat = request.getParameter("typeContrat");
            String titresAcademiques = request.getParameter("titresAcademiques");
            String evaluations = request.getParameter("evaluations");
            String autresInformations = request.getParameter("autresInformations");
    
            Enseignant enseignantToUpdate = new Enseignant(
                    id,
                    utilisateurID,
                    experience,
                    telephone,
                    siteWeb,
                    niveauxSouhaites,
                    disponibilites,
                    typeContrat,
                    titresAcademiques,
                    evaluations,
                    autresInformations
            );
    
            enseignantDAO.updateEnseignant(enseignantToUpdate);
            response.sendRedirect("enseignants.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erreur lors de la mise à jour de l'enseignant.");
        }
    }
    
    private void deleteEnseignant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        enseignantDAO.deleteEnseignant(id);
        response.sendRedirect("enseignants.jsp"); 
    }

    private void getEnseignant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Enseignant enseignant = enseignantDAO.getEnseignantById(id);
        if (enseignant != null) {
            request.setAttribute("enseignant", enseignant);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/enseignant-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Enseignant not found");
        }
    }

    private void listEnseignants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Enseignant> listEnseignants = enseignantDAO.getAllEnseignants();
        request.setAttribute("listEnseignants", listEnseignants);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/enseignant-list.jsp");
        dispatcher.forward(request, response);
    }
}
