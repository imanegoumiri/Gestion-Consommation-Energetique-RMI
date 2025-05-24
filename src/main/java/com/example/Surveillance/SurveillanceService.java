package com.example.Surveillance;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SurveillanceService extends Remote {
    void envoyeDonnes() throws RemoteException;
}
