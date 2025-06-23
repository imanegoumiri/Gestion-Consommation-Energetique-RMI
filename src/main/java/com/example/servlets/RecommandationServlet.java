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
        String appareil = request.getParameter("appareil");
        RecommandationProxy proxy = new RecommandationProxy();
        List<String> conseils = proxy.getConseils(appareil);

        request.setAttribute("conseils", conseils);
        request.getRequestDispatcher("recommandations.jsp").forward(request, response);
    }
}

