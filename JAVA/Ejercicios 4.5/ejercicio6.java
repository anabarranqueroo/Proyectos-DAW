import java.util.Scanner;
public class ejercicio6{
    static final double g=9.81;
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Introduce la altura h: ");
    double h = s.nextDouble(); 

    double t= Math.sqrt(2*h/g);

    System.out.printf("Tarda %.2f segundos" ,t);
 }
}