package ejercicios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class ejercicio11 {
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

        int numero;

        String[] array = diccionario.keySet().toArray(new String[0]);
        ArrayList<Integer> aleatorios = new ArrayList<Integer>();
        aleatorios.add((int)(Math.random()*20));
        for (int i = 0; i < 4; i++) {
            numero = (int)(Math.random()*20);
            while (aleatorios.contains(numero)) {
                numero = (int)(Math.random()*20);
            }
            aleatorios.add(numero);
        }

        int puntos=0;

        System.out.println("Traduceme estas palabras al ingles, puedes conseguir hasta 5 puntos.");
        for (int i = 0; i < 5; i++) {
            System.out.print(array[aleatorios.get(i)] + ": ");
            String respuesta = sc.nextLine();
            if (respuesta.equals(diccionario.get(array[aleatorios.get(i)]))) {
                puntos++;
                System.out.println("Respuesta correcta");
            }else{
                System.out.println("Respuesta incorrecta");
            }
        }
        System.out.println("Tienes " + puntos + " puntos de 5.");
    }
}
