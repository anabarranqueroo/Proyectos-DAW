import java.util.Scanner;
public class ejercicio1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.print("Introduce el primer numero: ");
        int numero1=s.nextInt();

        System.out.print("Introduce el segundo numero: ");
        int numero2=s.nextInt();

        int total=numero1*numero2;
        System.out.print("La multiplicacion de los numeros introducidos es: "+total);
    }}
