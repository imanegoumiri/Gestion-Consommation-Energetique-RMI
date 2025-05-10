package Recommandation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRecommandation extends Remote {
    String genererConseil(String nomAppareil) throws RemoteException;
}


// import java.rmi.Remote;
// import java.rmi.RemoteException;

// public interface IRecommandation extends Remote {
//     void verifierSeuil(String appareil, double consommation) throws RemoteException;
//     void envoyerAlerte(String message) throws RemoteException;
// }
