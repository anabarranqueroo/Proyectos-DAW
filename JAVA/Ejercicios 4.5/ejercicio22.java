import java.util.Scanner;
public class ejercicio22 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Por favor, introduzca un día de la semana (de lunes a viernes): ");
    String dia = s.nextLine();
    int diaNumerico = 0;

    switch(dia) {
      case "lunes" -> diaNumerico = 0;
      case "martes" -> diaNumerico = 1;
      case "miércoles", "miercoles" -> diaNumerico = 2;
      case "jueves" -> diaNumerico = 3;
      case "viernes" -> diaNumerico = 4;
      default -> System.out.print("El día introducido no es correcto.");
    }
    
    System.out.println("A continuación introduzca la hora (hora y minutos)");
    
    System.out.print("Hora: ");
    int horas = s.nextInt();
    
    System.out.print("Minutos: ");
    int minutos = s.nextInt();
    
    int minutosTotales = (4 * 24 * 60) + (15 * 60);
    int minutosActuales = (diaNumerico * 24 * 60) + (horas * 60) + minutos;
    
    System.out.print("Faltan " + (minutosTotales - minutosActuales) + " minutos para llegar al fin de semana.");
  }
}