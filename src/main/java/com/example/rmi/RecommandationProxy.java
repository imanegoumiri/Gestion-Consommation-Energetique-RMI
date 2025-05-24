package com.example.rmi;

import com.example.Recommandation.IRecommandation;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RecommandationProxy {

    private IRecommandation recommandationStub;

    public RecommandationProxy() {
        try {
            // Connexion au registre RMI du serveur de recommandation (port 3002)
            Registry registry = LocateRegistry.getRegistry("localhost", 3002);
            recommandationStub = (IRecommandation) registry.lookup("ServiceRecommandation");
            System.out.println("🔗 Proxy connecté au ServiceRecommandation !");
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion au ServiceRecommandation : " + e.getMessage());
        }
    }

    public List<String> getConseils(String appareil) {
        try {
            return recommandationStub.genererConseil(appareil);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

