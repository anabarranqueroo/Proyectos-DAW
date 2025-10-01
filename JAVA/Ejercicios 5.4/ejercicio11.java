import java.util.Scanner;

public class ejercicio11 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce un numero entero");
    int num = s.nextInt();

    for (int i=num; i<num+5; i++){
        int cuadrado=i*i;
        int cubo=i*i*i;
        System.out.printf("%-5d%-5d%-5d\n", i, cuadrado, cubo);
        
    }
    
    }
} 