import java.util.Scanner;
import java.util.ArrayList;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> n = new ArrayList<String>();
        n.add("Alex");
        n.add("Bob");
        n.add("Charles");
        n.add("David");
        n.add("Jack");
        n.add("Joe");

        System.out.println("Lista de nombres: ");
        for (String nombre : n) {
            System.out.println(nombre);
        }

    }
}
