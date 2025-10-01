import java.util.Scanner;

public class ejercicio15 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.print("Introduce la base (número real): ");
    int base=s.nextInt();

    System.out.print("Introduce el exponente (entero positivo): ");
    int exponente = s.nextInt();

    if (exponente>0) {
        for (int i = 1; i <= exponente; i++){
            int resultado=1;
            for (int j=1; j<=i; j++){
                resultado=resultado*base;
            }
            System.out.println(+base +"^"+i);
             }    
    } else {
        System.out.println("El exponente tiene que ser positivo.");
    }
    }
}