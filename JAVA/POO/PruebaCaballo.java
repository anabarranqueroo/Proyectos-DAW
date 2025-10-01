public class PruebaCaballo {
 public static void main(String[] args) {
    Caballo felipe = new Caballo ("marron", 10);
    System.out.println("El color de felipe es: " + felipe.getColor());
    System.out.println("La edad de felipe es: " + felipe.getEdad());
    
    System.out.println("¿Como trota el caballo?");
    felipe.trotar();
    System.out.println("toma hierba");
    felipe.come("hierba");
    System.out.println("toma pasto");
    felipe.come("pasto");

    felipe.trotar();

    }
 }