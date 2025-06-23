package com.example.Gestion;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestionInterface extends Remote {
    void envoyerAlerte(String appareilId, String message) throws RemoteException;
    void controlerAppareil(String appareilId, boolean allumer) throws RemoteException;
}