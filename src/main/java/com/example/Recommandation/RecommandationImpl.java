package com.example.Recommandation;

import com.example.Analyse.ConsoRecord;
import com.example.Analyse.IAnalyse;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RecommandationImpl extends UnicastRemoteObject implements IRecommandation {

    private IAnalyse analyse;

    public RecommandationImpl() throws RemoteException {
        try {
            // Connexion au serveur d’analyse
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            analyse = (IAnalyse) registry.lookup("ServiceAnalyse");
            System.out.println("🔗 Connecté au serveur d’analyse avec succès !");
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion au serveur d’analyse : " + e.getMessage());
        }
    }

    @Override
    public List<String> genererConseil(String appareil) throws RemoteException {
        List<String> conseils = new ArrayList<>();

        try {
            List<ConsoRecord> historique = analyse.getHistoriqueComplet(appareil);
            double moyenne = analyse.calculerMoyenne(appareil);

            conseils.add("📊 Moyenne générale de consommation : " + String.format("%.2f", moyenne) + " kW");

            for (ConsoRecord record : historique) {
                double conso = record.getConsommation();
                String ts = record.getTimestamp();

                if (conso > moyenne + 2) {
                    conseils.add("⚠️ Haute consommation détectée à " + ts + " → " + conso + " kW. Pensez à éteindre l’appareil.");
                } else if (conso < moyenne / 2) {
                    conseils.add("ℹ️ Faible consommation à " + ts + " → " + conso + " kW. L'appareil est probablement en veille.");
                } else {
                    conseils.add("✅ Consommation normale à " + ts + " → " + conso + " kW.");
                }
            }

        } catch (Exception e) {
            conseils.add("❌ Erreur lors de la génération des conseils : " + e.getMessage());
        }

        return conseils;
    }
}
