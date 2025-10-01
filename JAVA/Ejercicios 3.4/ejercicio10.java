import java.util.Scanner;
public class ejercicio10{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce un numero en Mb: ");
        int mb=s.nextInt();

        int total=mb*1000;
        System.out.println("Son "+total+" Kb");
    }
}