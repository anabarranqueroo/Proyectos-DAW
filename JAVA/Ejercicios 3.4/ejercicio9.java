import java.util.Scanner;
public class ejercicio9{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Dime el radio del cono: ");
        int r= s.nextInt();

        System.out.println("Dime la altura del cono: ");
        int h= s.nextInt();

        double total=(Math.PI*r*r*h)/3;
        System.out.println("El volumen del cono es "+total);
    }
}