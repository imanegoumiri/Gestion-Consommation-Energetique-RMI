package Gestion;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurGestion {
    public static void main(String[] args) {
        try {
            GestionInterface gestion = new GestionImpl();

            Registry registry = LocateRegistry.getRegistry(); // NE PAS créer, juste récupérer
registry.rebind("ServeurGestion", gestion);

            System.out.println("Serveur de Gestion prêt et en attente...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}