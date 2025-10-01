 import java.util.Scanner;
 public class operadoreslogicos {
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Adivina el número que estoy pensando.");
    System.out.print("Introduce un número entre el 1 y el 100: ");
    
    int n = Integer.parseInt(s.nextLine());

        if ((n < 1) || (n > 100)) {
            System.out.println("El número introducido debe estar en el intervalo 1- 100.");
            System.out.print("Tienes otra oportunidad, introduce un número: ");

     }
        if (n == 24) {
            System.out.println("¡Enhorabuena!, ¡has acertado!");
        } else {

    System.out.println("Lo siento, ese no es el número que estoy pensando.");
        }
     }
 }