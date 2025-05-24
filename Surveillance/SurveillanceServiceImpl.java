package Surveillance;
import Analyse.IAnalyse;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.*;

public class SurveillanceServiceImpl extends UnicastRemoteObject implements SurveillanceService {

    public SurveillanceServiceImpl() throws RemoteException {
        super();
    }

    public void envoyeDonnes() throws RemoteException {
        try {
            // Connexion au serveur d'analyse via RMI
            IAnalyse analyse = (IAnalyse) Naming.lookup("rmi://localhost/ServiceAnalyse");

            // Lecture du fichier CSV
            BufferedReader reader = new BufferedReader(new FileReader("DataBase/consommation.csv"));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // ignorer l'en-tête
                    continue;
                }

                String[] parts = line.split(";");
                String date = parts[0]; // Date
                String time = parts[1]; // Time

                String val = parts[2]; // Global_active_power

                if (val.equals("?") || val.isEmpty()) continue; // données manquantes

                double power = Double.parseDouble(val.replace(",", ".")); // remplacement de virgule

                analyse.stockerDonnee("Maison", power, date + " " + time); // appel RMI
                System.out.println("Envoyé : " + power + " kW à " + date + " " + time);

                Thread.sleep(1000); // simulation d’un envoi chaque seconde
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
