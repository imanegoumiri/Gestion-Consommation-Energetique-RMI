package Analyse;

import java.util.List;

public class TestAnalyse {
    public static void main(String[] args) throws Exception {
        AnalyseImpl analyse = new AnalyseImpl();

        // 1. Moyenne
        System.out.println("Moyenne = " + analyse.calculerMoyenne("Maison") + " kW");

        // 2. Alertes
        List<String> alertes = analyse.detecterAnomalies("Maison");
        alertes.forEach(System.out::println);

        // 3. Historique
        List<ConsoRecord> historique = analyse.getHistoriqueComplet("Maison");
        System.out.println("\nHistorique de consommation pour 'Maison' :");
            for (ConsoRecord rec : historique) {
                System.out.println(rec);
            }
    }
}
