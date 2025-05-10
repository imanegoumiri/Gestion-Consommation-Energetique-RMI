package Recommandation;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurRecommandation {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            IRecommandation reco = new RecommandationImpl();
            Naming.rebind("rmi://localhost:1099/RecommandationService", reco);
            System.out.println("✅ Serveur de recommandation prêt sur le port 1099.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
