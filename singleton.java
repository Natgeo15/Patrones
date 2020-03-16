package singleton;
 
import java.util.Date;
 
public class Reloj extends Thread {
 
    private static Reloj ;
 
    private synchronized static void createInstance() {
        if (reloj == null) {
            reloj = new Reloj();
            reloj.start();
        }
    }
    public static Reloj getInstancia() {
        createInstance();
 
        return reloj;
    }
 
    /**
     * Imprime por pantalla la hora cada segundo
     */
 
    @Override
    public void run() {
        while (true) {
 
            Date hora = new Date(System.currentTimeMillis());
            System.out.println(hora);
 
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
        }
 
    }
 
}