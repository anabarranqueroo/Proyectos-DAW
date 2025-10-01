import java.util.Scanner;

public class ejercicio17 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce un numero");
    int num=s.nextInt();

    if (num>0) {
        for (int i=0; i<101; i++) {
            num=(num+1)+i;
        }
    } else {
        System.out.println("El numero debe ser positivo.");
    }
    System.out.println("La suma del numero mas los 100 siguientes es: "+num);
}
}