package Analyse;
import java.util.List;

public class TestAnalyse {
    public static void main(String[] args) throws Exception {
        AnalyseImpl analyse = new AnalyseImpl();
        System.out.println("Moyenne = " + analyse.calculerMoyenne("Maison") + " kW");

        List<String> alertes = analyse.detecterAnomalies("Maison");
        alertes.forEach(System.out::println);
    }
}
