import java.util.Scanner;
public class ejercicio15{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Introduce un caracter (letra, número o símbolo; *, +, -, $, &): ");
    char c = s.next().charAt(0);

    System.out.println("¿Hacia donde quiere el vertice de la piramide?");
    System.out.println("1.arriba");
    System.out.println("2.abajo");
    System.out.println("3.izquierda");
    System.out.println("4.derecha");
    int v = s.nextInt();

    switch (v) {
        case 1 -> {
            System.out.println("    "+c);
            System.out.println("   "+c+" "+c);
            System.out.println("  "+c+" "+c+" "+c);
            System.out.println(" "+c+" "+c+" "+c+" "+c);
            }

        case 2 -> {
            System.out.println(" "+c+" "+c+" "+c+" "+c);
            System.out.println("  "+c+" "+c+" "+c);
            System.out.println("   "+c+" "+c);
            System.out.println("    "+c);
            }

        case 3 -> {
            System.out.println(c);
            System.out.println(c +" "+c);
            System.out.println(c +" "+c+" "+c);
            System.out.println(c +" "+c+" "+c+" "+c);
            }

        case 4 -> {
            System.out.println("       "+c);
            System.out.println("     "+c+" "+c);
            System.out.println("   "+c+" "+c+" "+c);
            System.out.println(" "+c+" "+c+" "+c+" "+c);
            }

        default -> System.out.println("No has elegido la direccion del vertice.");
        }
    }
} 