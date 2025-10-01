import java.util.Scanner;
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce la cantidad de pesetas: ");
        int pesetas=s.nextInt();

        double total=0.00601*pesetas;
        System.out.println("Son "+total +" euros");
    }}