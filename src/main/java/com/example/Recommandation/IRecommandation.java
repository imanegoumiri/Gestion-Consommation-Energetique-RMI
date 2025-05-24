package com.example.Recommandation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRecommandation extends Remote {
    List<String> genererConseil(String appareil) throws RemoteException;
}
