package controllers;

import dao.*;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.*;

import java.util.Date;

import java.io.IOException;
import java.util.List;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

    @Inject
    private UtilisateurDAO utilisateurDAO;
    @Inject
    private EnseignantDAO enseignantDAO;
    @Inject
    private EcoleDAO ecoleDAO;
    @Inject
    private CandidatureDAO candidatureDAO;
    @Inject
    private BesoinDAO besoinDAO;

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
            case "logout":
                logout(request, response);
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

        if (role == "Enseignant") {
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
        } else if (role == "Recruteur") {
            int utilisateurID = utilisateur.getID();
            String raisonSociale = request.getParameter("raisonSociale");
            String adresse = request.getParameter("adresse");

            Ecole ecole = new Ecole();
            ecole.setUtilisateurID(utilisateurID);
            ecole.setRaisonSociale(raisonSociale);
            ecole.setAdresse(adresse);

            utilisateurDAO.addUser(utilisateur);
            ecoleDAO.addEcole(ecole);
        } else {
            utilisateurDAO.addUser(utilisateur);
        }
        response.sendRedirect("login.jsp");
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
        Utilisateur utilisateur = utilisateurDAO.login(mail, motDePasse);
        if (utilisateur != null) {
            String role = utilisateur.getRole();
            request.getSession().setAttribute("user", utilisateur);
            if ("Enseignant".equals(role)) {
                System.out.println("Enseignant");
                List<Candidature> candidatures = candidatureDAO.getCandidaturesByEnseignantId(utilisateur.getID());
                System.out.println("Candidatures: " + candidatures);
                request.setAttribute("listCandidatures", candidatures);
                request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
            } else if ("Recruteur".equals(role)) {
                System.out.println("Recruteur");
                List<Besoin> besoins = besoinDAO.getBesoinsByEcoleID(utilisateur.getID());
                System.out.println("Besoins: " + besoins);
                request.setAttribute("listBesoins", besoins);
                request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
            } else if ("Admin".equals(role)) {
                System.out.println("Admin");
                List<Utilisateur> users = utilisateurDAO.getAllUtilisateurs();
                System.out.println("Users: " + users);
                request.setAttribute("listUsers", users);
                request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
            } else {
                // Gérer d'autres rôles ou afficher un message d'erreur si le rôle n'est pas reconnu
                response.sendRedirect("/erreur.jsp");
            }
        } else {
            System.out.println("User not found");
            request.setAttribute("loginError", true);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalider la session pour déconnecter l'utilisateur
        HttpSession session = request.getSession(false); // false signifie ne pas créer une nouvelle session si elle n'existe pas
        if (session != null) {
            session.invalidate(); // Cela va détruire la session
        }
        // Rediriger vers la page de connexion ou la page d'accueil après la déconnexion
        response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
    }
}
