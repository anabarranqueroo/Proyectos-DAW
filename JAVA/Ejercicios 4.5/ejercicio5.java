import java.util.Scanner;
public class ejercicio5{
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Este programa resuelve ecuaciones de primer grado del tipo ax+b=0");
    System.out.println("Introduce el valor de a: ");
    double a = s.nextDouble();
    System.out.println("Introduce el valor de b: ");
    double b = s.nextDouble();

    double x = -b / a;

    if (a!=0) {
        System.out.println("El resultado es: "+x);
    }else{
        System.out.println("La ecuación no tiene solución real.");
         }    
     }
 }