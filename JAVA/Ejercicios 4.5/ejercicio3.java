import java.util.Scanner;
public class ejercicio3{
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Escribe un numero del 1 al 7: ");
    int num = s.nextInt();
    String dia;

    dia = switch (num) {
         case 1 -> "Lunes";
         case 2 -> "Martes";
         case 3 -> "Miercoles";
         case 4 -> "Jueves";
         case 5 -> "Viernes";
         case 6 -> "Sabado";
         case 7 -> "Domingo";
         default -> "no existe";
     };
    System.out.println("El  " + num + " es " + dia);
     }
 }