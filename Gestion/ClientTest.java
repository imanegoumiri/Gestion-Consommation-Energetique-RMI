package Gestion;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            GestionInterface gestion = (GestionInterface) registry.lookup("ServeurGestion");

            // Envoi d'une alerte
            gestion.envoyerAlerte("climatiseur", "Consommation excessive détectée !");

            // Contrôle d'appareils
            gestion.controlerAppareil("chauffage", true);   // allumer
            gestion.controlerAppareil("lave-linge", false); // éteindre

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
