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

    @Override
    public void stockerDonnee(String appareil, double consommation, String timestamp) throws RemoteException {
    // Méthode requise par l'interface mais inutile ici (on lit depuis la base importée)
        System.out.println("Reçu : " + appareil + " => " + consommation + " kW à " + timestamp);
    }

    // 1. Moyenne générale de Global_active_power
    public double calculerMoyenne(String appareil) throws RemoteException {
        double moyenne = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT AVG(Global_active_power) FROM consommation"
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
                "SELECT Date, Time, Global_active_power FROM consommation WHERE Global_active_power > 5"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String date = rs.getString("Date");
                String time = rs.getString("Time");
                double conso = rs.getDouble("Global_active_power");
                alertes.add("Alerte " + conso + " kW le " + date + " à " + time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alertes;
    }
}
