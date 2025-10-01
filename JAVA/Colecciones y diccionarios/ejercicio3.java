import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el numero: ");
            a.add(sc.nextInt());
        }
        Collections.sort(a);
        System.out.println("Lista: "+a);

    }
}
