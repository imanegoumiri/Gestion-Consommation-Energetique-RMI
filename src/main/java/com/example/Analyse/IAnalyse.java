package com.example.Analyse;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IAnalyse extends Remote {
    void stockerDonnee(String appareil, double consommation, String timestamp) throws RemoteException;
    double calculerMoyenne(String appareil) throws RemoteException;
    List<String> detecterAnomalies(String appareil) throws RemoteException;
    List<ConsoRecord> getHistoriqueComplet(String appareil) throws RemoteException;
}
