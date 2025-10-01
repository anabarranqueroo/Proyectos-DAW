import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int[]num = new int[15];

    for (int i = 0; i < 15; i++) {
        System.out.println("Introduce un numero: ");
        num[i]=s.nextInt();
    }

    int ultimo=num[14];

    for (int i = 14; i >0; i--) {
        num[i]=num[i-1];
    }

    num[0]=ultimo;
    
    System.out.println("Rotación de array: ");
    for (int i = 0; i < 15; i++) {
        System.out.println(num[i]);
    }

    }
} 