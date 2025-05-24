package Surveillance;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class SurveillanceServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1100); // port différent si besoin
            SurveillanceServiceImpl surveillance = new SurveillanceServiceImpl();
            Naming.rebind("rmi://localhost/ServiceSurveillance", surveillance);
            System.out.println(" Serveur de surveillance prêt.");

            // Appel immédiat pour lancer la surveillance
            surveillance.envoyeDonnes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
