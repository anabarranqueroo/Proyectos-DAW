import java.util.Scanner;
public class ejercicio11{
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);

        System.out.println("Introduce un numero en Kb: ");
        int kb=s.nextInt();

        double total=kb/0.001;
        System.out.println("Son "+total+" Mb");
    }
}