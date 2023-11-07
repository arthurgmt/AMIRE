package controllers;

import dao.EnseignantDAO;
import dao.UtilisateurDAO;
import dao.EcoleDAO;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Enseignant;
import models.Utilisateur;
import models.Ecole;
import java.util.Date;

import java.io.IOException;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

    @Inject
    private UtilisateurDAO utilisateurDAO;
    private EnseignantDAO enseignantDAO;
    private EcoleDAO ecoleDAO;

    @Override
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
        String action = request.getParameter("action");

        switch (action) {
            case "register":
                createUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "login":
                login(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                deleteUser(request, response);
                break;
            case "get":
                getUser(request, response);
                break;
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String motDePasse = request.getParameter("motDePasse");
        String role = request.getParameter("role");

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setMail(mail);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setRole(role);

        if (role == "enseignant") {
            int utilisateurID = utilisateur.getID();
            String telephone = request.getParameter("telephone");
            Date disponibilites = new Date(request.getParameter("disponibilites"));
            String competences = request.getParameter("competences");

            Enseignant enseignant = new Enseignant();

            enseignant.setUtilisateurID(utilisateurID);
            enseignant.setTelephone(telephone);
            enseignant.setDisponibilites(disponibilites);
            enseignant.setCompetences(competences);

            utilisateurDAO.addUser(utilisateur);
            enseignantDAO.addEnseignant(enseignant);
        } else if (role == "recruteur") {
            int utilisateurID = utilisateur.getID();
            String raisonSociale = request.getParameter("raisonSociale");
            String adresse = request.getParameter("adresse");

            Ecole ecole = new Ecole();
            ecole.setUtilisateurID(utilisateurID);
            ecole.setRaisonSociale(raisonSociale);
            ecole.setAdresse(adresse);

            utilisateurDAO.addUser(utilisateur);
            ecoleDAO.addEcole(ecole);
            // response.sendRedirect("login.jsp");
        } else {
            utilisateurDAO.addUser(utilisateur);
            // response.sendRedirect("login.jsp");
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String motDePasse = request.getParameter("motDePasse");
        String role = request.getParameter("role");

        Utilisateur utilisateur = new Utilisateur();
        // id, nom, prenom, mail, motDePasse, role
        utilisateur.setID(id);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setMail(mail);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setRole(role);

        utilisateurDAO.updateUser(utilisateur);
        // response.sendRedirect("users.jsp");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateurDAO.deleteUser(id);
        // response.sendRedirect("users.jsp");
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Utilisateur utilisateur = utilisateurDAO.getUserById(id);
        if (utilisateur != null) {
            request.setAttribute("user", utilisateur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user-detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String motDePasse = request.getParameter("motDePasse");
        System.out.println("try connection");
        Utilisateur utilisateur = utilisateurDAO.login(mail, motDePasse);
        System.out.println(utilisateur);
        if (utilisateur != null) {
            request.setAttribute("user", utilisateur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user.jsp");
            dispatcher.forward(request, response);
        } else {
            System.out.println("User not found");
            request.setAttribute("loginError", true);
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }
}
