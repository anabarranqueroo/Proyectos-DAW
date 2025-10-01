 import java.util.Scanner;
 public class ifswitchnumeros {
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Por favor, introduce un número entero: ");
    int x = Integer.parseInt(s.nextLine());

        if (x < 0) {
            System.out.println("El número introducido es negativo.");
        } else {

    System.out.println("El número introducido es positivo.");
         }
     }
 }