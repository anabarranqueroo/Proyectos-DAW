package ejercicios;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String>diccionario = new HashMap<String,String>();
        diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("coche", "car");
        diccionario.put("mesa", "table");
        diccionario.put("silla", "chair");
        diccionario.put("puerta", "door");
        diccionario.put("ventana", "window");
        diccionario.put("caballo", "horse");
        diccionario.put("lobo", "wolf");
        diccionario.put("flor", "flower");
        diccionario.put("arbol", "tree");
        diccionario.put("luz", "light");
        diccionario.put("agua", "water");
        diccionario.put("comida", "food");
        diccionario.put("ropa", "clothes");
        diccionario.put("zapato", "shoe");
        diccionario.put("mano", "hand");
        diccionario.put("ojo", "eye");
        diccionario.put("boca", "mouth");

        String palabra;

        System.out.println("Inserta una palabra en español: ");
        System.out.println("casa, perro, gato, coche, mesa, silla, puerta, ventana, caballo, lobo , flor, arbol, luz, agua, comida, ropa, zapato, mano, ojo, boca");
        palabra = sc.nextLine();
            if (diccionario.containsKey(palabra)) {
                System.out.println("La traducción de " + palabra + " es " + diccionario.get(palabra));
            }
            if (!diccionario.containsKey(palabra)) {
                System.out.println("La palabra no se encuentra en el diccionario.");
            }
    }
}
