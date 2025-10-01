import java.util. Scanner;
public class Ejercicio1{
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);

        int factorial=1;
        int i=1;

        System.out.println("Por favor introduzca un numero entero positivo: ");
        int num= s.nextInt();

        while (i<=num) { 
            factorial=factorial*i;  
            i++;
            System.out.println(i-1+"!="+factorial);
        }

    }
}