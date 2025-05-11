import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class GestionImpl extends UnicastRemoteObject implements GestionInterface {

    public GestionImpl() throws RemoteException {
        super();
    }

    @Override
    public void envoyerAlerte(String appareilId, String message) throws RemoteException {
        System.out.println("ALERTE pour " + appareilId + " : " + message);

    }

    @Override
    public void controlerAppareil(String appareilId, boolean allumer) throws RemoteException {
        String etat = allumer ? "allumé" : "éteint";
        System.out.println("Commande envoyée à " + appareilId + " : " + etat);

    }
}