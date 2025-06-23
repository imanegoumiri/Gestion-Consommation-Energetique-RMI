package com.example.rmi;

import com.example.Gestion.GestionInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GestionProxy {

    private static GestionInterface gestionStub;

    static {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1098); // même port que ton ServeurGestion
            gestionStub = (GestionInterface) registry.lookup("ServiceGestion");
            System.out.println("🔗 Proxy connecté au ServiceGestion !");
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion au ServiceGestion : " + e.getMessage());
            gestionStub = null;
        }
    }

    public static GestionInterface getService() {
        return gestionStub;
    }
}
