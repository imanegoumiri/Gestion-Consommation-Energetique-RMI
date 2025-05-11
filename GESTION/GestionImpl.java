import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class GestionImpl extends UnicastRemoteObject implements GestionInterface {

    public GestionImpl() throws RemoteException {
        super();
    }

    @Override
    public void envoyerAlerte(String appareilId, String message) throws RemoteException {
        System.out.println("ALERTE pour " + appareilId + " : " + message);
        // Tu peux ajouter ici un enregistrement dans une base de données ou affichage web
    }

    @Override
    public void controlerAppareil(String appareilId, boolean allumer) throws RemoteException {
        String etat = allumer ? "allumé" : "éteint";
        System.out.println("Commande envoyée à " + appareilId + " : " + etat);
        // Simulation de l’action réelle
    }
}