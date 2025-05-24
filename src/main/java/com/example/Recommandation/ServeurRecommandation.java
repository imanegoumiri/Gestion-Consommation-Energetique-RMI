package com.example.Recommandation;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class ServeurRecommandation {
      public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(3002);
            IRecommandation obj = new RecommandationImpl();
            Naming.rebind("rmi://localhost:3002/ServiceRecommandation", obj);
            System.out.println("✅ Serveur de recommandation démarré !");
        } catch (Exception e) {
            System.err.println("❌ Erreur de démarrage du serveur de recommandation : " + e.getMessage());
        }
    }
}