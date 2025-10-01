import java.util.Scanner;
public class ejercicio2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.print("Introduce la cantidad de euros: ");
        int euros=s.nextInt();

        double total=166.386*euros;
        System.out.println("Son "+total +" pesetas");
    }}