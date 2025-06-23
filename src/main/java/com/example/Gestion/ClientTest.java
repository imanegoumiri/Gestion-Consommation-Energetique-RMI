package client;

import com.example.Gestion.GestionInterface;
import java.rmi.Naming;

public class ClientTest {
    public static void main(String[] args) {
        try {
            GestionInterface gestion = (GestionInterface) Naming.lookup("rmi://localhost:1098/ServiceGestion");

            gestion.envoyerAlerte("Maison", "Consommation dépassée !");
            gestion.controlerAppareil("Maison", false);
            System.out.println("État actuel : " + gestion.getEtatMaison());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
