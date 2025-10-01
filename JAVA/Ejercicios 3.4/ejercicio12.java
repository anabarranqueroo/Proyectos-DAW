import java.util.Scanner;
public class ejercicio12 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce la nota del primer examen: ");
        double nota = s.nextDouble();

        System.out.println("¿Que nota quieres sacar en el trimestre? ");
        double trimestre = s.nextDouble();

        double nota2 = 10-(nota*0.4);
        System.out.println("Para tener un "+trimestre +" en el trimestre necesitas sacar un " +nota2 +" en el segundo examen.");
        
 }
 }