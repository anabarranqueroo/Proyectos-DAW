import java.util.Scanner;
public class ejercicio5 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce el largo del rectangulo: ");
        int largo=s.nextInt();

        System.out.println("Introduce el ancho del rectangulo: ");
        int ancho=s.nextInt();

        int total=ancho*largo;
        System.out.println("El area del rectangulo es: "+total);
    }}