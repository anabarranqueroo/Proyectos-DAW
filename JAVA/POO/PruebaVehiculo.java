import java.util.Scanner;

public class PruebaVehiculo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
           
        Coche Coche = new Coche();
        Bicicleta bici = new Bicicleta();
    
        int nummenu;
        int km;

         do {
            System.out.println("VEHÍCULOS");
            System.out.println("=========");
            System.out.println("1. Anda con la bicicleta");
            System.out.println("2. Haz el caballito con la bicicleta");
            System.out.println("3. Anda con el coche");
            System.out.println("4. Quema rueda con el coche");
            System.out.println("5. Ver kilometraje de la bicicleta");
            System.out.println("6. Ver kilometraje del coche");
            System.out.println("7. Ver kilometraje total");
            System.out.println("8. Salir");
            System.out.print("Elige una opción (1-8): ");
            nummenu = s.nextInt();

            switch (nummenu) {
                case 1:
                    System.out.print("Cuántos kilómetros quieres andar con la bicicleta? ");
                    km = s.nextInt();
                    bici.recorre(km);
                    break;
                case 2:
                    bici.hacerCaballito();
                    break;
                case 3:
                    System.out.print("Cuántos kilómetros quieres andar con el coche? ");
                    km = s.nextInt();
                    Coche.recorre(km);
                    break;
                case 4:
                    Coche.derraparCoche();
                    break;
                case 5:
                    System.out.println("Kilometraje de la bicicleta: " + bici.getkilometrosRecorridos()+ " km");
                    break;
                case 6:
                    System.out.println("Kilometraje del coche: " + Coche.getkilometrosRecorridos() + " km");
                    break;
                case 7:
                    System.out.println("Kilometraje total: " + Vehiculo.getkilometrosTotales() + " km");
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
            System.out.println();
        } while (nummenu != 8);
    }
}