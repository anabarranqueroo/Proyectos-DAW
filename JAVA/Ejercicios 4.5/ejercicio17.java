 import java.util.Scanner;
 public class ejercicio17 {
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Introduce un numero entero: ");
    int num = s.nextInt();
 System.out.println("La última cifra del número introducido es el " + (num % 10));
    
    }
 }