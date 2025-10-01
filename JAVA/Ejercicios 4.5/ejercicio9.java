import java.util.Scanner;
public class ejercicio9{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Este programa va a resolver una ecuacion de segundo grado ax2+bx+c=0");
    System.out.println("Introduce el valor de a: ");
    double a = s.nextDouble();

    System.out.println("Introduce el valor de b: ");
    double b = s.nextDouble();

    System.out.println("Introduce el valor de c: ");
    double c = s.nextDouble();

    double d = b*b-4*a*c;

    if (d>0) {
        double r1 = (-b + Math.sqrt(d)) / (2*a);
        double r2 = (-b - Math.sqrt(d)) / (2*a);
        System.out.println("Las raices son: " +r1 +" y " +r2);
    }else if (d==0) {
        double r = -b / (2*a);
        System.out.println("La raiz doble es: "+r);
    } else {
        System.out.println("No hay raices reales.");
    
        }
    } 
}