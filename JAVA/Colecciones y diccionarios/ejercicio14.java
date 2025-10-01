package ejercicios;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> productos = new HashMap<String, Double>();
        ArrayList<String> listap = new ArrayList<String>();
        ArrayList<Integer> listac = new ArrayList<Integer>();

        productos.put("avena", 2.21);
        productos.put("garbanzos", 2.39);
        productos.put("tomate", 1.59);
        productos.put("jengibre", 3.13);
        productos.put("quinoa", 4.50);
        productos.put("guisantes", 1.60);

        String producto;
        int cantidad = 0;
        double total = 0;
        String codigo;
        double descuento = 0;

        do {
            System.out.println("Para finalizar la compra, escribe 'fin'.");
            System.out.println("Producto: ");
            producto = sc.nextLine();
            if (!producto.equals("fin")) {
                System.out.println("Cantidad: ");
                cantidad = sc.nextInt();
                if (listap.contains(producto)) {
                    int posicion = listap.indexOf(producto);
                    listac.set(posicion, listac.get(posicion) + cantidad);
                }else{
                    listap.add(producto);
                    listac.add(cantidad);
                }
            }
        } while (!producto.equals("fin"));

        System.out.println("Introduzca el codigo de descuento: (Si no tiene pulse intro)");
        codigo = sc.nextLine();

        System.out.println("Producto  Precio  Cantidad  Subtotal");
        for (int i = 0; i < listap.size(); i++) {
            producto = listap.get(i);
            double precio = productos.get(producto);
            cantidad = listac.get(i);
            double subtotal = precio * cantidad;
            total += subtotal;
            System.out.printf("%-8s %7.2f %6d %7.2f\n", producto, precio, cantidad, subtotal);
        }

        if(codigo.equals("ECODTO")){
            descuento = total / 10;
            total = total - descuento;
        }
        System.out.println("Descuento: " + descuento);
        System.out.println("Total: " + total);
    }
}
