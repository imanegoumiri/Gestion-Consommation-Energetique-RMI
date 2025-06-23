package com.example.servlets;

import com.example.Analyse.IAnalyse;
import com.example.rmi.AnalyseProxy;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class AlertesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            IAnalyse analyse = AnalyseProxy.getService();
            List<String> alertes = analyse.detecterAnomalies("maison");

            request.setAttribute("alertes", alertes);

        } catch (RemoteException e) {
            e.printStackTrace();
            request.setAttribute("alertes", List.of("Erreur lors de la récupération des alertes."));
        }

        request.setAttribute("pageTitle", "Alertes de consommation");
        request.setAttribute("contentPage", "alertes.jsp");
        request.getRequestDispatcher("templates.jsp").forward(request, response);
    }
}
