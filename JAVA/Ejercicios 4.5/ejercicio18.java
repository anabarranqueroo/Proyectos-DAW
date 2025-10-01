 import java.util.Scanner;
  public class ejercicio18 {
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int primera = 0;
    
    System.out.print("Por favor, introduzca un número entero positivo (5 cifras como máximo): ");
    int num = s.nextInt();
    
    if ( num < 10 ) {
      primera = num;
    }
    
    if (( num >= 10 ) && ( num < 100 )) {
      primera = num / 10;
    }
    
    if (( num >= 100 ) && ( num < 1000 )) {
      primera = num / 100;
    }
    
    if (( num >= 1000 ) && ( num < 10000 )) {
      primera = num / 1000;
    }
    
    if ( num >= 10000 ) {
      primera = num / 10000;
    }
    
    System.out.println("La primera cifra del número introducido es el " + primera + ".");
  }
}