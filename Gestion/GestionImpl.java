package Gestion;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Analyse.IAnalyse; // importe l'interface distante
import java.util.List;

public class GestionImpl extends UnicastRemoteObject implements GestionInterface {

    public GestionImpl() throws RemoteException {
        super();
    }

    @Override
    public void envoyerAlerte(String appareilId, String message) throws RemoteException {
        System.out.println("🔔 ALERTE pour " + appareilId + " : " + message);

        try {
            // Appel distant vers le serveur d’analyse
            IAnalyse analyse = (IAnalyse) Naming.lookup("rmi://localhost/ServiceAnalyse");

            List<String> alertes = analyse.detecterAnomalies(appareilId);
            System.out.println("📡 Alertes détectées :");
            alertes.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Erreur lors de la communication avec Analyse : " + e.getMessage());
        }
    }

    @Override
    public void controlerAppareil(String appareilId, boolean allumer) throws RemoteException {
        String etat = allumer ? "✅ allumé" : "⛔ éteint";
        System.out.println("🔧 Commande envoyée à " + appareilId + " : " + etat);
    }
}
