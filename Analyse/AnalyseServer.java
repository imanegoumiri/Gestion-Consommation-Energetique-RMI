package Analyse;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class AnalyseServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            AnalyseImpl analyse = new AnalyseImpl();
            Naming.rebind("rmi://localhost/ServiceAnalyse", analyse);
            System.out.println("Serveur d'analyse en ligne...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
