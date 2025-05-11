import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SurveillanceServer {
    public static void main(String[] args) {
        try {
            SurveillanceService service = new SurveillanceServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // ممكن كل سيرفر فـ بورت خاص
            registry.rebind("SurveillanceService", service);
            System.out.println("Surveillance Service prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}