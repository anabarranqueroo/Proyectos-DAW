package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartaEj8> cartas = new ArrayList<CartaEj8>();
        CartaEj8 carta = new CartaEj8();
        cartas.add(carta);

        for (int i = 0; i < 9; i++) {
            do {
                carta = new CartaEj8();
            } while (cartas.contains(carta));
            cartas.add(carta);
        }
        Collections.sort(cartas);
        for (CartaEj8 c : cartas) {
            System.out.println(c);
        }
    }
}