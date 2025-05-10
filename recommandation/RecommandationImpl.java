package Recommandation;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class RecommandationImpl extends UnicastRemoteObject implements IRecommandation {

    public RecommandationImpl() throws RemoteException {
        super();
    }

    @Override
    public String genererConseil(String appareil) throws RemoteException {
        switch (appareil.toLowerCase()) {
            case "chauffage":
                return "Réduisez la température ou éteignez le chauffage.";
            case "climatiseur":
                return "Augmentez la température ou éteignez le climatiseur.";
            case "machine à laver":
                return "Utilisez-la en heures creuses.";
            default:
                return "Éteignez l'appareil s'il n'est pas utilisé.";
        }
    }
}
