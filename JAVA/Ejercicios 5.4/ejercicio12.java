import java.util.Scanner;

public class ejercicio12 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    
    System.out.println("Introduce un numero");
    int num = s.nextInt();

    int a=0;
    int b=1;

    for (int i = 1; i <= num; i++) {
       System.out.print(" " +a); 
       int sig= a+b;
       a=b;
       b=sig;
    }    
    System.out.print("");
    
    }
}