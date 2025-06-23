package com.example.Surveillance;

import com.example.Analyse.IAnalyse;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SurveillanceServiceImpl extends UnicastRemoteObject implements SurveillanceService {

    public SurveillanceServiceImpl() throws RemoteException {
        super();
    }

    public void envoyeDonnes() throws RemoteException {
        try {
            // Connexion RMI au serveur d'analyse
            IAnalyse analyse = (IAnalyse) Naming.lookup("rmi://localhost/ServiceAnalyse");

            // Chargement fichier CSV depuis resources
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("dbfile/consommation.csv");
            if (inputStream == null) {
                System.out.println("❌ Fichier consommation.csv introuvable !");
                return;
            }

            // Formats de date
            SimpleDateFormat csvFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                boolean firstLine = true;

                while ((line = reader.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false; // ignorer l'en-tête
                        continue;
                    }

                    String[] parts = line.split(";");
                    String date = parts[0]; // ex: 01/06/2024
                    String time = parts[1]; // ex: 00:00:00
                    String val = parts[2];  // Global_active_power

                    if (val.equals("?") || val.isEmpty()) continue;

                    double power = Double.parseDouble(val.replace(",", "."));

                    // Reformatage timestamp au format ISO pour MySQL
                    String rawTimestamp = date + " " + time;
                    Date parsedDate = csvFormat.parse(rawTimestamp);
                    String timestamp = sqlFormat.format(parsedDate);

                    analyse.stockerDonnee("Maison", power, timestamp);
                    System.out.println("✅ Envoyé : " + power + " kW à " + timestamp);

                    Thread.sleep(1000); // Simulation d'envoi
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
