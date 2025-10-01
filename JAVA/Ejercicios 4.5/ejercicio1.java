import java.util.Scanner;
public class ejercicio1{
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Introduce un dia de la semana (Lunes- Viernes) ");
    String dia = s.nextLine();
    String asignatura;

    asignatura = switch (dia) {
         case "Lunes" -> "Base de datos";
         case "Martes" -> "Base de datos";
         case "Miercoles" -> "Sistemas informaticos";
         case "Jueves" -> "Sistemas informaticos";
         case "Viernes" -> "Sostenibilidad";
         default -> "no hay clases";
     };
    System.out.println("El  " + dia + " toca " + asignatura);
     }
 }