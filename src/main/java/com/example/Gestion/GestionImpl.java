package com.example.Gestion;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.example.Analyse.IAnalyse;
import java.util.List;

public class GestionImpl extends UnicastRemoteObject implements GestionInterface {

    private boolean maisonAllumee = true;

    public GestionImpl() throws RemoteException {
        super();
    }

    @Override
    public void envoyerAlerte(String appareilId, String message) throws RemoteException {
        System.out.println("🔔 ALERTE pour " + appareilId + " : " + message);

        try {
            IAnalyse analyse = (IAnalyse) Naming.lookup("rmi://localhost:1099/ServiceAnalyse");
            List<String> alertes = analyse.detecterAnomalies(appareilId);

            System.out.println("📡 Alertes détectées pour " + appareilId + ":");
            alertes.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("❌ Erreur communication avec Analyse : " + e.getMessage());
        }
    }

    @Override
    public void controlerAppareil(String appareilId, boolean allumer) throws RemoteException {
        String etat = allumer ? "✅ allumé" : "⛔ éteint";
        System.out.println("🔧 Commande envoyée à " + appareilId + " : " + etat);
        maisonAllumee = allumer;
    }

    @Override
    public boolean getEtatMaison() throws RemoteException {
        return maisonAllumee;
    }
}
