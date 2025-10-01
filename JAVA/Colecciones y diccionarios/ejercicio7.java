package ejercicios;
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<MonedaEj7> m = new ArrayList<MonedaEj7>();

        MonedaEj7 moneda = new MonedaEj7();
        m.add(moneda);

        String ultPos = moneda.getPosicion();
        String ultCan = moneda.getCantidad();

        for (int i = 0; i < 5; i++) {
            do {
                moneda = new MonedaEj7();
            } while (!((moneda.getPosicion()).equals(ultPos)) && !((moneda.getCantidad()).equals(ultCan)));
            m.add(moneda);

            ultPos = moneda.getPosicion();
            ultCan = moneda.getCantidad();
        }
            for (MonedaEj7 mo : m){
                System.out.println(mo);
            }
        }
    }
