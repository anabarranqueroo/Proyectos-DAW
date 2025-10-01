import java.util.Scanner;
public class ejercicio21 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Nota del primer examen: ");
    double nota1 = s.nextDouble();
    System.out.print("Nota del segundo examen: ");
    double nota2 = s.nextDouble();
    
    double media = (nota1 + nota2) / 2;
    
    if (media < 5) {

      System.out.print("¿Cuál ha sido el resultado de la recuperación? (apto/no apto): ");
      String recuperacion = s.nextLine();
        if (recuperacion.equals("apto")) {
            media = 5;
        }else{
            System.out.println("Has suspendido.");
        }
    }
    
    System.out.print("Tu nota de Programación es " + media);
  }
}