package com.example.servlets;

import java.io.IOException;
import java.util.List;
import java.rmi.RemoteException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.rmi.AnalyseProxy;
import com.example.Analyse.IAnalyse;
import com.example.Analyse.ConsoRecord;


public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IAnalyse analyse = AnalyseProxy.getService();

        try {
            List<ConsoRecord> historique = analyse.getHistoriqueComplet("Maison");
            request.setAttribute("historique", historique);
        } catch (RemoteException e) {
            request.setAttribute("error", "Erreur RMI : " + e.getMessage());
            e.printStackTrace();
        }

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
