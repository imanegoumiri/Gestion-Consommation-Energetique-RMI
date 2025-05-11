import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class SurveillanceServiceImpl extends UnicastRemoteObject implements SurveillanceService {

    protected SurveillanceServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void envoyerDonnees(String appareilId, double consommation) throws RemoteException {
        System.out.println("Donnée reçue de " + appareilId + " : " + consommation + " W");
    }
}