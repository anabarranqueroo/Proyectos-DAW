 public class switchh{
 public static void main(String[] args) {
    System.out.print("Por favor, introduzca un numero de mes: ");
    int mes = Integer.parseInt(System.console().readLine());
    String nombreDelMes;

    nombreDelMes = switch (mes) {
         case 1 -> "enero";
         case 2 -> "febrero";
         case 3 -> "marzo";
         case 4 -> "abril";
         case 5 -> "mayo";
         case 6 -> "junio";
         case 7 -> "julio";
         case 8 -> "agosto";
         case 9 -> "septiembre";
         case 10 -> "octubre";
         case 11 -> "noviembre";
         case 12 -> "diciembre";
         default -> "no existe ese mes";
     };
    System.out.println("Mes " + mes + ": " + nombreDelMes);
     }
 }