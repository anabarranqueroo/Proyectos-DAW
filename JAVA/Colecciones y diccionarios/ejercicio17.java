package ejercicios;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ejercicio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CarritoEj17 miCarrito = new CarritoEj17();
        miCarrito.agrega(new ElementoEj17("Tarjeta SD 64Gb", 19.95, 2));
        miCarrito.agrega(new ElementoEj17("Canon EOS 2000D", 449, 1));
        System.out.println(miCarrito);
        System.out.print("Hay " + miCarrito.numeroDeElementos());
        System.out.println(" productos en la cesta.");
        System.out.println("El total asciende a " + String.format("%.2f", miCarrito.importeTotal()) + " euros");
        System.out.println("\nContinúa la compra...\n");
        miCarrito.agrega(new ElementoEj17("Samsung Galaxy Tab", 199, 3));
        miCarrito.agrega(new ElementoEj17("Tarjeta SD 64Gb", 19.95, 1));
        System.out.println(miCarrito);
        System.out.print("Ahora hay " + miCarrito.numeroDeElementos());
        System.out.println(" productos en la cesta.");
        System.out.println("El total asciende a " + String.format("%.2f", miCarrito.importeTotal()) + " euros");
    }
}
