import java.util.Scanner;
public class ejercicio7 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("¿Cuanto te ha costado el primer producto? ");
        int p1=s.nextInt();

        System.out.println("¿Cuanto te ha costado el segundo producto?");
        int p2=s.nextInt();

        int total=p1+p2;
        System.out.println("El total de la factura es: "+total+"euros");
    }}