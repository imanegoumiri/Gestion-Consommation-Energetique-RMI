import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurGestion {
    public static void main(String[] args) {
        try {
            GestionInterface gestion = new GestionImpl();
<<<<<<< HEAD
            Registry registry = LocateRegistry.createRegistry(1099); // Port RMI
=======
            Registry registry = LocateRegistry.createRegistry(1099); 
>>>>>>> ce77118 (ajout serveur de gestion - LAMAHAD Maryam)
            registry.rebind("ServeurGestion", gestion);
            System.out.println("Serveur de Gestion prêt et en attente...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}