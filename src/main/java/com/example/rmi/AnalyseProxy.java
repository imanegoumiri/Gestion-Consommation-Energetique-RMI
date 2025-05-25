package com.example.rmi;

import com.example.Analyse.IAnalyse;
import java.rmi.Naming;

public class AnalyseProxy {
    public static IAnalyse getService() {
        try {
            IAnalyse service = (IAnalyse) Naming.lookup("rmi://localhost/ServiceAnalyse");
            System.out.println("✅ Connexion RMI réussie à ServiceAnalyse");
            return service;
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion RMI à ServiceAnalyse : " + e);
            return null;
        }
    }
}

