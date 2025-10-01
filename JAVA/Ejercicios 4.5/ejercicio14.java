import java.util.Scanner;
public class ejercicio14{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Introduce un numero");
    int num = s.nextInt();

    if (num%5==0 && num%2==0) {
        System.out.println("Es divisible entre 5 y es par.");
    
    } else if(num%5!=0 && num%2==0) {
        System.out.println("No es divisible entre 5 y es par.");
    
    } else if(num%5==0 && num%2!=0) {
        System.out.println("Es divisible entre 5 y es impar.");
    
    } else if(num%5!=0 && num%2!=0) {
        System.out.println("No es divisible entre 5 y es impar.");
    }
 }

}
 