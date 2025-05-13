package Analyse;
import DataBase.DBManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;

public class AnalyseImpl extends UnicastRemoteObject implements IAnalyse {
    Connection conn;

    public AnalyseImpl() throws RemoteException {
        super();
        conn = DBManager.getConnection(); // Tu as déjà cette classe
    }

    public void stockerDonnee(String appareil, double consommation, String timestamp) throws RemoteException {
    try {
        // Préparer la requête d'insertion
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO consommations (appareil, consommation, timestamp) VALUES (?, ?, ?)"
        );
        ps.setString(1, appareil);
        ps.setDouble(2, consommation);
        ps.setString(3, timestamp); // format : "16/12/2006 17:24:00"
        
        ps.executeUpdate();

        System.out.println("Donnée stockée : " + consommation + " kW à " + timestamp);

    } catch (SQLException e) {
        System.err.println("Erreur lors du stockage : " + e.getMessage());
    }
}


    // 1. Moyenne générale de Global_active_power
    public double calculerMoyenne(String appareil) throws RemoteException {
        double moyenne = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT AVG(consommation) FROM consommations"
            );
            ResultSet rs = ps.executeQuery();
            if (rs.next()) moyenne = rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moyenne;
    }

    // 2. Détection de consommation > seuil (ex: 5kW)
    public List<String> detecterAnomalies(String appareil) throws RemoteException {
        List<String> alertes = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT consommation, timestamp FROM consommations WHERE consommation > 5"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double conso = rs.getDouble("consommation");
                String timestamp = rs.getString("timestamp");
                alertes.add("Alerte " + conso + " kW à " + timestamp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alertes;
    }
}
