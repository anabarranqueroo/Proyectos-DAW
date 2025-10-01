import java.util.Scanner;
public class ejercicio6 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce la base del triangulo: ");
        int base=s.nextInt();

        System.out.println("Introduce la altura del rectangulo: ");
        int altura=s.nextInt();

        int total=(base*altura)/2;
        System.out.println("El area del triangulo es: "+total);
    }}