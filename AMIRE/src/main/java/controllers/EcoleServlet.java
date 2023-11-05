package controllers;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ecole")
public class EcoleServlet extends HttpServlet {


    public EcoleServlet() {
    }

    public void getAllEcole() {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET ECOLE");
        resp.getWriter().println("GET ECOLE");
    }
}
