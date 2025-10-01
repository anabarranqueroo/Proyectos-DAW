 import java.util.Scanner;
 public class NumeroPrimo {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        
        System.out.print("Introduzca un número entero positivo: ");
        int n = s.nextInt();

        if (esPrimo(n)) {
            System.out.println("El " + n + " es primo.");
        } else {
            System.out.println("El " + n + " no es primo.");
        }
    } 
    /*  @param num un número entero positivo
        @return true si el número es primo
        @return false en caso contrario*/

    public static boolean esPrimo(int num) {
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
 }


 
