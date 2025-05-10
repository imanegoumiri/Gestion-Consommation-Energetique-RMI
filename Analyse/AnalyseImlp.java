Package RMI;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnalyseImpl extends UnicastRemoteObject implements IAnalyse {
    Connection conn;

    protected AnalyseImpl() throws RemoteException {
        super();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/energie", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stockerDonnee(String appareil, double consommation, String timestamp) throws RemoteException {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO consommations (appareil, consommation, timestamp) VALUES (?, ?, ?)");
            ps.setString(1, appareil);
            ps.setDouble(2, consommation);
            ps.setString(3, timestamp);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double calculerMoyenne(String appareil) throws RemoteException {
        double moyenne = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT AVG(consommation) FROM consommations WHERE appareil = ?");
            ps.setString(1, appareil);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                moyenne = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moyenne;
    }

    public List<String> detecterAnomalies(String appareil) throws RemoteException {
        List<String> alertes = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT consommation, timestamp FROM consommations WHERE appareil = ?");
            ps.setString(1, appareil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double conso = rs.getDouble(1);
                String time = rs.getString(2);
                if (conso > 5.0) { // seuil critique
                    alertes.add("Alerte haute consommation à " + time);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alertes;
    }
}
