import java.util.Scanner;
import java.util.ArrayList;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int suma = 0;;
        int max = 0;
        int min = 9999;
        int tamaño = (int) (Math.random() * 11) + 10;

        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < tamaño; i++) {
            a.add((int) (Math.random() * 101));
        }

        System.out.println("Lista: "+a);

        for (int n : a) {
            suma += n;

            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        System.out.println("Suma: "+suma);
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        System.out.println("Media: "+suma/tamaño);
    }
}
