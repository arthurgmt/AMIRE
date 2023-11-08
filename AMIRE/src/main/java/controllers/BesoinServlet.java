package controllers;

import dao.BesoinDAO;
import dao.CandidatureDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Besoin;

import java.io.IOException;

@WebServlet("/besoin")
public class BesoinServlet extends HttpServlet {
    @Inject
    BesoinDAO besoinDAO;
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
                createBesoin(request, response);
                break;
            case "update":
                updateBesoin(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteBesoin(request, response);
                break;
            case "getall":
                getAllBesoin(request, response);
                break;
            case "get":
                getBesoin(request, response);
                break;
            case "getbyname":
                getBesoinByName(request, response);
                break;
            case "getbycompetence":
                getCandidatureByBesoinAndCompetence(request, response);
                break;

        }
    }

    private void createBesoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int EcoleID = Integer.parseInt(request.getParameter("EcoleID"));
        String Periode = request.getParameter("Periode");
        String Remarque = request.getParameter("Remarque");
        String Competence = request.getParameter("Competence");

        Besoin besoin = new Besoin();
        besoin.setEcoleID(EcoleID);
        besoin.setPeriode(Periode);
        besoin.setRemarques(Remarque);
        besoin.setCompetences(Competence);

        besoinDAO.addBesoin(besoin);
        // response.sendRedirect("besoin.jsp");
    }

    private void updateBesoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int EcoleID = Integer.parseInt(request.getParameter("EcoleID"));
        String Periode = request.getParameter("Periode");
        String Remarque = request.getParameter("Remarque");
        String Competence = request.getParameter("Competence");

        Besoin besoin = new Besoin();
        besoin.setEcoleID(EcoleID);
        besoin.setPeriode(Periode);
        besoin.setRemarques(Remarque);
        besoin.setCompetences(Competence);

        besoinDAO.updateBesoin(besoin);
    }

    private void deleteBesoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        besoinDAO.deleteBesoin(id);
        // response.sendRedirect("users.jsp");
    }

    private void getBesoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Besoin besoin = besoinDAO.getBesoinById(id);
        if (besoin != null) {
            request.setAttribute("user", besoin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Besoin not found");
        }
    }

    private void getAllBesoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", besoinDAO.getAllBesoins());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }

    private void getBesoinByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("users", besoinDAO.getBesoinsByEcoleName(name));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }

    private void getCandidatureByBesoinAndCompetence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String competence = request.getParameter("competence");
        int besoinID = Integer.parseInt(request.getParameter("besoinID"));
        request.setAttribute("users", candidatureDAO.getCandidaturesByCompetenceEnseignantAndBesoinID(competence, besoinID));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/users.jsp");
        dispatcher.forward(request, response);
    }
}
