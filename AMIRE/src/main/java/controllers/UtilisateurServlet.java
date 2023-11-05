package controllers;

import dao.*;
import models.Utilisateur;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

    private UtilisateurDAO utilisateurDAO;

    public void init() {
        utilisateurDAO = new UtilisateurDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        utilisateurDAO.addUser(utilisateur);

        if (role.equals("Enseignant")) {
            response.sendRedirect("/enseignant/enseignant.jsp"); 
        } else if (role.equals("Ecole")) {
            response.sendRedirect("/ecole/ecole.jsp"); 
        } else {
            response.sendRedirect("/index.jsp"); 
        }
    }

    private Utilisateur updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String motDePasse = request.getParameter("motDePasse");
        String role = request.getParameter("role");

        Utilisateur utilisateur = new Utilisateur(id, nom, prenom, mail, motDePasse, role);
        utilisateurDAO.updateUser(utilisateur);

        return utilisateur;
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
            request.setAttribute("user", utilisateur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/user.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        }
    }
}