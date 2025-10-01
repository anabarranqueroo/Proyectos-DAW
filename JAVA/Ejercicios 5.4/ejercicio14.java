import java.util.Scanner;

public class ejercicio14 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce la base (entero positivo):");
    int base=s.nextInt();
    System.out.println("Introduce el exponente (entero positivo):");
    int exp=s.nextInt();

    int pot=1;
    if (base>0 && exp>0) {
        for (int i = 1; i <= exp; i++) {
            pot=base*pot;
        }
    } else {
        System.out.println("Introduce un numero postivo.");
    }
    System.out.println("La potencia es "+pot);
    
    }
}