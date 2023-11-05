package controllers;

import dao.EcoleDAO;
import models.Ecole;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ecole")
public class EcoleServlet extends HttpServlet {

    private EcoleDAO ecoleDAO;

    public void init() {
        ecoleDAO = new EcoleDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteEcole(request, response);
                break;
            case "get":
                getEcole(request, response);
                break;
            case "list":
                listEcoles(request, response);
                break;
        }
    }

    private void createEcole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String siteWeb = request.getParameter("siteWeb");
        String contact = request.getParameter("contact");

        Ecole ecole = new Ecole();
        ecole.setRaisonSociale(raisonSociale);
        ecole.setAdresse(adresse);
        ecole.setSiteWeb(siteWeb);
        ecole.setContact(contact);

        ecoleDAO.addEcole(ecole);
        response.sendRedirect("ecoles.jsp"); // adjust the redirection supersimista
    }

    private void updateEcole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String siteWeb = request.getParameter("siteWeb");
        String contact = request.getParameter("contact");

        Ecole ecole = new Ecole(id, raisonSociale, adresse, siteWeb, contact);
        ecoleDAO.updateEcole(ecole);
        response.sendRedirect("ecoles.jsp"); // adjust the redirection simista la resta
    }

    private void deleteEcole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ecoleDAO.deleteEcole(id);
        response.sendRedirect("ecoles.jsp"); // adjust the redirection simista pro front
    }

    private void getEcole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ecole ecole = ecoleDAO.getEcoleById(id);
        if (ecole != null) {
            request.setAttribute("ecole", ecole);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ecole-detail.jsp"); // adjust the path simista bibiche
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "School not found");
        }
    }

    private void listEcoles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ecoles", ecoleDAO.getAllEcoles());
        RequestDispatcher dispatcher = request.getRequestDispatcher("ecoles.jsp"); // adjust the path simistaaaaaaa
        dispatcher.forward(request, response);
    }
}
