import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SurveillanceService extends Remote {
    void envoyerDonnees(String appareilId, double consommation) throws RemoteException;
}