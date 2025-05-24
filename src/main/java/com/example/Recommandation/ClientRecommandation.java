package com.example.Recommandation;

import java.rmi.Naming;
import java.util.List;

public class ClientRecommandation {
    public static void main(String[] args) {
        try {
            IRecommandation reco = (IRecommandation) Naming.lookup("rmi://localhost:1100/RecommandationService");
            String appareil = "chauffage";

            List<String> conseils = reco.genererConseil(appareil); // ✅

            System.out.println("📋 Conseils pour '" + appareil + "' :");
            for (String conseil : conseils) {
                System.out.println("👉 " + conseil); // ✅ Affiche chaque ligne
            }

        } catch (Exception e) {
            System.err.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
