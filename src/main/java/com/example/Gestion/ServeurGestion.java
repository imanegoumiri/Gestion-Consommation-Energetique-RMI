package com.example.Gestion;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class ServeurGestion {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1098); // port dédié
            GestionImpl service = new GestionImpl();
            Naming.rebind("rmi://localhost:1098/ServiceGestion", service);
            System.out.println("✅ Serveur de gestion lancé !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
