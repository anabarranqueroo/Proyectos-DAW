import java.util.Scanner;

public class ejercicio10 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int num;
    int c=0;
    int i=0;
    do { 
        System.out.println("Introduce un numero");
        num = s.nextInt();
        if (num > 0) {
            c = c + num;
            i++;
        }
    } while (num>0);
    
    System.out.println("La media de los numeros es "+c/i);
    
    }
} 