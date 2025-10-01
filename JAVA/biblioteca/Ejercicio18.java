import java.util.Scanner;
public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce un numero decimal: ");
        int n = s.nextInt();
        int res = 1;

        while (n > 1) { 
            res = (res * 10) + n % 2;
            n = n / 2;
        }
        res = (res * 10) + 1;
        res = matematicas.funciones.voltea(res);
        res = res / 10;

        System.out.println("EL numero en binario es: "+res);
    }

}