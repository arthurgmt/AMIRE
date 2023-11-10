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
import models.Ecole;
import models.Utilisateur;

import java.io.IOException;
import java.util.List;

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
            case "list":
                List<Besoin> besoins = getAllBesoin(request, response);
                request.setAttribute("besoins", besoins);
                request.getRequestDispatcher("/listBesoin.jsp").forward(request, response);
                break;
            case "listEnseignantBesoin":
                List<Besoin> besoinsEnseignant = getAllBesoin(request, response);
                request.setAttribute("besoins", besoinsEnseignant);
                request.getRequestDispatcher("/BesoinEnseignant.jsp").forward(request, response);
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

    private void createBesoin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Ecole ecole = (Ecole) request.getSession().getAttribute("ecole");
        int EcoleID = ecole.getID();
        String Periode = request.getParameter("periode");
        String Remarque = request.getParameter("remarques");
        String Competence = request.getParameter("competences");

        Besoin besoin = new Besoin();
        if (EcoleID >= 0) besoin.setEcoleID(EcoleID);
        if (Periode != null) besoin.setPeriode(Periode);
        if (Remarque != null) besoin.setRemarques(Remarque);
        if (Competence != null) besoin.setCompetences(Competence);

        besoinDAO.addBesoin(besoin);
        response.sendRedirect(request.getContextPath() + "/besoin?action=list");
    }

    private void updateBesoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        int EcoleID = Integer.parseInt(request.getParameter("EcoleID"));
        String Periode = request.getParameter("Periode");
        String Remarque = request.getParameter("Remarque");
        String Competence = request.getParameter("Competence");

        Besoin besoin = besoinDAO.getBesoinById(ID);
        if (besoin == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Besoin not found");
            return;
        }
        if (EcoleID >= 0) besoin.setEcoleID(EcoleID);
        if (Periode != null) besoin.setPeriode(Periode);
        if (Remarque != null) besoin.setRemarques(Remarque);
        if (Competence != null) besoin.setCompetences(Competence);
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

    private List<Besoin> getAllBesoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return besoinDAO.getAllBesoins();
    }

    private void getBesoinByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("besoins", besoinDAO.getBesoinsByEcoleName(name));
        request.setAttribute("recherche", name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BesoinEnseignant.jsp");
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
