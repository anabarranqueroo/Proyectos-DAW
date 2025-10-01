import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese una palabra: ");
            a.add(sc.nextLine());
        }
        Collections.sort(a);
        System.out.println("Lista: "+a);

    }
}
