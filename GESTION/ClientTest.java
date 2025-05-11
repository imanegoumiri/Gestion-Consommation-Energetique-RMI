import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            GestionInterface gestion = (GestionInterface) registry.lookup("ServeurGestion");

            gestion.envoyerAlerte("climatiseur", "Consommation excessive détectée !");
            gestion.controlerAppareil("chauffage", false); // Éteindre

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}