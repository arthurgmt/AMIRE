package controllers;

import dao.EcoleDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Ecole;
import models.Enseignant;

import java.util.Date;

import java.io.IOException;

@WebServlet("/ecole")
public class EcoleServlet extends HttpServlet {

    @Inject
    private EcoleDAO ecoleDAO;

    @Override
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createEcole(request, response);
                break;
            case "update":
                updateEcole(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteEcole(request, response);
                break;
            case "getall":
                getAllEcole(request, response);
                break;
            case "get":
                getEcole(request, response);
                break;
            case "getbyname":
                getEcoleByName(request, response);
                break;
            
        }
    }

    private void createEcole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int UtilisateurID = Integer.parseInt(request.getParameter("UtilisateurID"));
        String RaisonSociale = request.getParameter("RaisonSociale");
        String Adresse = request.getParameter("Adresse");
        String SiteWeb = request.getParameter("SiteWeb");
        String Contact = request.getParameter("Contact");
        String Nom = request.getParameter("Nom");

        Ecole ecole = new Ecole();
        ecole.setUtilisateurID(UtilisateurID);
        ecole.setRaisonSociale(RaisonSociale);
        ecole.setAdresse(Adresse);
        ecole.setSiteWeb(SiteWeb);
        ecole.setContact(Contact);
        ecole.setNom(Nom);

        ecoleDAO.addEcole(ecole);
        // response.sendRedirect("ecole.jsp");
    }

    private void updateEcole(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String RaisonSociale = request.getParameter("RaisonSociale");
        String Adresse = request.getParameter("Adresse");
        String SiteWeb = request.getParameter("SiteWeb");
        String Contact = request.getParameter("Contact");
        String Nom = request.getParameter("Nom");

        Ecole ecole = ecoleDAO.getEcoleById(id);

        ecole.setRaisonSociale(RaisonSociale);
        ecole.setAdresse(Adresse);
        ecole.setSiteWeb(SiteWeb);
        ecole.setContact(Contact);
        ecole.setNom(Nom);  

        ecoleDAO.updateEcole(ecole);
    }

    private void deleteEcole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ecoleDAO.deleteEcole(id);
        // response.sendRedirect("users.jsp");
    }

    private void getEcole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ecole ecole = ecoleDAO.getEcoleById(id);
        if (ecole != null) {
            request.setAttribute("user", ecole);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ecole not found");
        }
    }

    private void getAllEcole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", ecoleDAO.getAllEcoles());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }

    private void getEcoleByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        request.setAttribute("users", ecoleDAO.getEcolesByNom(nom));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }
}
