package rmi;

import com.example.Gestion.GestionInterface;
import java.rmi.Naming;

public class GestionProxy {
    public static GestionInterface getService() {
        try {
            return (GestionInterface) Naming.lookup("rmi://localhost:1098/ServiceGestion");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
