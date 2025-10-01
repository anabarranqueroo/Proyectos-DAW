import java.util.Scanner;
public class ejercicio7{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Dime tu primera nota ");
    double n1 = s.nextDouble(); 

    System.out.println("Dime tu segunda nota ");
    double n2 = s.nextDouble(); 

    System.out.println("Dime tu tercera nota ");
    double n3 = s.nextDouble(); 

    double media=(n1+n2+n3)/3;

    System.out.printf("La media de las tres notas es: %.2f", media);
 }
}