import java.util.Scanner;
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce el primer numero: ");
        int numero1=s.nextInt();

        System.out.println("Introduce el segundo numero: ");
        int numero2=s.nextInt();
        
        int suma, resta, multiplicacion;
        int division;

        suma=numero1+numero2;
        resta=numero1-numero2;
        multiplicacion=numero1*numero2;

        System.out.println("La suma es "+suma);
        System.out.println("La resta es "+resta);
        System.out.println("La multiplicacion es "+multiplicacion);
        System.out.println("La division es "+(double)numero1/numero2);
    }}
