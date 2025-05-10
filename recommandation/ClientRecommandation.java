package Recommandation;

import java.rmi.Naming;

public class ClientRecommandation {
    public static void main(String[] args) {
        try {
            IRecommandation reco = (IRecommandation) Naming.lookup("rmi://localhost:1099/RecommandationService");

            String appareil = "climatiseur";
            String conseil = reco.genererConseil(appareil);

            System.out.println("Conseil reçu : " + conseil);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
