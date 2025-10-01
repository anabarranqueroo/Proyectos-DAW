package ejercicios;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ejercicio19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<String, String>();

        diccionario.put("caliente", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("ardiente", "hot");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("abrasador", "hot");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");

        String palabra = "";
        String respuesta = "";
        String sinonimo;
        String traduccion;

        do {
            System.out.println("Introduzca una palabra y le daré los sinónimos: ");
            palabra = sc.nextLine();

            if (!palabra.equals("salir")) {
                if (!diccionario.keySet().contains(palabra)) {
                    System.out.println("No conozco esa palabra ¿quiere añadirla al diccionario? (s/n): ");
                    respuesta = sc.nextLine();
                    if (respuesta.equals("s")) {
                        System.out.println("Introduzca la traduccion de " + palabra + " en ingles: ");
                        traduccion = sc.nextLine();
                        diccionario.put(palabra, traduccion);
                    }
                } else {
                    ArrayList<String> sinonimos = encontrarSinonimos(palabra, diccionario);
                    if (sinonimos.isEmpty()) {
                        System.out.println("No conozco sinónimos de esa palabra ¿Quiere añadir alguno? (s/n): ");
                        respuesta = sc.nextLine();
                        if (respuesta.equals("s")) {
                            System.out.println("Introduzca un sinonimo de " + palabra + ": ");
                            sinonimo = sc.nextLine();
                            diccionario.put(sinonimo, diccionario.get(palabra));
                            System.out.println("Gracias por enseñarme nuevos sinonimos.");
                        }
                    } else {
                        String significado  = diccionario.get(palabra);
                        System.out.println("Sinonimos de " + palabra + ": ");
                        ArrayList<String> s = new ArrayList<>();
                        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
                            if (entrada.getValue().equals(palabra) && entrada.getValue().equals(significado)) {
                                s.add((String)entrada.getKey());
                            }
                        }
                        System.out.println(String.join(", ", sinonimos));
                    }
                }
            }
        } while (!palabra.equals("salir"));
    }

    private static ArrayList<String> encontrarSinonimos(String palabra, HashMap<String, String> diccionario) {
        ArrayList<String> sinonimos = new ArrayList<>();
        String significado = diccionario.get(palabra);

        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
            if (entrada.getValue().equals(significado) && !entrada.getKey().equals(palabra)) {
                sinonimos.add(entrada.getKey());
            }
        }

        return sinonimos;
    }
}
