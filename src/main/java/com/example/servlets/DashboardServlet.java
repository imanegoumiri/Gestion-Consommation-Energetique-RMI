package com.example.servlets;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

            // Dernières 12 valeurs
            List<String> labels = historique.stream()
                    .map(ConsoRecord::getTimestamp)
                    .limit(12)
                    .collect(Collectors.toList());

            List<Double> graphData = historique.stream()
                    .map(ConsoRecord::getConsommation)
                    .limit(12)
                    .collect(Collectors.toList());

            request.setAttribute("labels", labels);
            request.setAttribute("graphData", graphData);

            // Moyenne par jour
            Map<String, Double> moyennes = historique.stream().collect(
                Collectors.groupingBy(
                    r -> r.getTimestamp().substring(0, 10),
                    LinkedHashMap::new,
                    Collectors.averagingDouble(ConsoRecord::getConsommation)
                )
            );
            request.setAttribute("moyennesLabels", new ArrayList<>(moyennes.keySet()));
            request.setAttribute("moyennesValues", new ArrayList<>(moyennes.values()));

            // Max par jour
            Map<String, Double> maxs = historique.stream().collect(
                Collectors.groupingBy(
                    r -> r.getTimestamp().substring(0, 10),
                    LinkedHashMap::new,
                    Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(ConsoRecord::getConsommation)),
                        opt -> opt.map(ConsoRecord::getConsommation).orElse(0.0)
                    )
                )
            );
            request.setAttribute("maxLabels", new ArrayList<>(maxs.keySet()));
            request.setAttribute("maxValues", new ArrayList<>(maxs.values()));

            // Répartition jour/nuit
            long jour = historique.stream().filter(r -> {
                int h = Integer.parseInt(r.getTimestamp().split(" ")[1].substring(0, 2));
                return h >= 6 && h <= 21;
            }).count();
            request.setAttribute("jour", jour);
            request.setAttribute("nuit", historique.size() - jour);

        } catch (RemoteException e) {
            request.setAttribute("error", "Erreur RMI : " + e.getMessage());
        }

        request.setAttribute("pageTitle", "Dashboard");
        request.setAttribute("contentPage", "dashboard.jsp");
        request.getRequestDispatcher("template.jsp").forward(request, response);
    }
}
