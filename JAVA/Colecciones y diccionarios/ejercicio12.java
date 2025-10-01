package ejercicios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartaEj8> carta = new ArrayList<CartaEj8>();
        HashMap<String, Integer> baraja = new HashMap<String, Integer>();
        baraja.put("sota", 2);
        baraja.put("caballo", 3);
        baraja.put("rey", 4);
        baraja.put("as", 11);
        baraja.put("dos", 0);
        baraja.put("tres", 10);
        baraja.put("cuatro", 0);
        baraja.put("cinco", 0);
        baraja.put("seis", 0);
        baraja.put("siete", 0);

        int puntos=0;

        CartaEj8 carta1 = new CartaEj8();
        carta.add(carta1);

        for (int i = 0; i < 5; i++) {
            do {
                carta1 = new CartaEj8();
            } while (carta.contains(carta1));
            carta.add(carta1);
        }
        for (CartaEj8 c : carta) {
            System.out.println(c);
            puntos+= baraja.get(c.getNumero());
        }
        System.out.println("Tienes " + puntos + " puntos.");
        }
    }

