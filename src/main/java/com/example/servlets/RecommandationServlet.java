package com.example.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.rmi.RecommandationProxy;

public class RecommandationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appareil = "maison"; // 💡 on fixe l'appareil à "maison"
        RecommandationProxy proxy = new RecommandationProxy();
        List<String> conseils = proxy.getConseils(appareil);

        request.setAttribute("conseils", conseils);
        request.setAttribute("pageTitle", "Conseils énergétiques");
        request.setAttribute("contentPage", "recommandations.jsp"); // 👉 inclusion dynamique dans template.jsp
        request.getRequestDispatcher("template.jsp").forward(request, response);
    }

    // Pour supporter aussi les requêtes POST si nécessaire
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}