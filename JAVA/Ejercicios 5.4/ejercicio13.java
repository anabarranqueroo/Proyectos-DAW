import java.util.Scanner;

public class ejercicio13 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int num=0;
    int pos=0;
    int neg=0;

    for (int i=1; i<11;i++) {
        System.out.println("Introduce un numero entero");
        num = s.nextInt();
        if (num>0) {
            pos++;
        } else {
            neg++;
        }
    }
    System.out.println("Numeros positivos: "+pos);
    System.out.println("Numeros negativos: "+neg);
    
    }
}