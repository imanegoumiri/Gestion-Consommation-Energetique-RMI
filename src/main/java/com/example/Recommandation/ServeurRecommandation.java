package com.example.Recommandation;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurRecommandation {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(3002); // Crée un registre RMI sur 3002
            IRecommandation reco = new RecommandationImpl();
            registry.rebind("ServiceRecommandation", reco); // Enregistre dans ce registre

            System.out.println("✅ Serveur de recommandation démarré sur le port 3002 !");
        } catch (Exception e) {
            System.err.println("❌ Erreur de démarrage du serveur de recommandation : " + e.getMessage());
        }
    }
}
