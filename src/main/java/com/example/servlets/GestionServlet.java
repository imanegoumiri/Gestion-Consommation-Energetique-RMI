package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.rmi.AnalyseProxy;
import com.example.Analyse.IAnalyse;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;


public class GestionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            IAnalyse analyse = AnalyseProxy.getService();
            List<String> alertes = analyse.detecterAnomalies("Maison");

            request.setAttribute("alertes", alertes);
        } catch (RemoteException e) {
            e.printStackTrace();
            request.setAttribute("error", "Erreur lors de la récupération des alertes.");
        }

        // Appelle alertes.jsp à travers le template
        request.setAttribute("pageTitle", "Alertes en Temps Réel");
        request.setAttribute("contentPage", "alertes.jsp");
        request.getRequestDispatcher("templates.jsp").forward(request, response);
    }
}
