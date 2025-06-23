package com.example.rmi;

import com.example.Recommandation.IRecommandation;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RecommandationProxy {

    private static IRecommandation recommandationStub;

    static {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 3002);
            recommandationStub = (IRecommandation) registry.lookup("ServiceRecommandation");
            System.out.println("🔗 Proxy connecté au ServiceRecommandation !");
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion au ServiceRecommandation : " + e.getMessage());
            recommandationStub = null;
        }
    }

    public static List<String> getConseils(String appareil) {
        if (recommandationStub == null) {
            System.err.println("❌ Service Recommandation indisponible");
            return List.of("Service indisponible pour le moment.");
        }

        try {
            return recommandationStub.genererConseil(appareil);
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la récupération des conseils : " + e.getMessage());
            return List.of("Erreur lors de l'accès aux conseils.");
        }
    }
}
