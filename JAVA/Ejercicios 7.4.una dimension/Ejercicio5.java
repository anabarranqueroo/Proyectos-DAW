import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int[]num = new int[10];
    int max=0;
    int min=9999;

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un numero: ");
            num[i]=s.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            if (num[i]>max) {
                max=num[i];
            }
            if (num[i]<min) {
                min=num[i];
            }
        }
            System.out.println("Maximo = " + max + "\nMinimo = " + min);
    }
}