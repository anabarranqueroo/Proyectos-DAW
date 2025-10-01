package ejercicios;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class ejercicio21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> diccionario1 = new HashMap<String, String>();
        diccionario1.put("rana", "tropicos y cerca de las zonas humedas y acuaticas");
        diccionario1.put("salamandra", "ecosistemas humedos");
        diccionario1.put("sapo", "en cualquier sitio salvo el desierto y la Antartida");
        diccionario1.put("triton", "america y africa");
        HashMap<String, String> diccionario2 = new HashMap<String, String>();
        diccionario2.put("rana", "larvas e insectos");
        diccionario2.put("salamandra", "pequeños crustaceos e insectos");
        diccionario2.put("sapo", "insectos, lombrices y pequeños roedores");
        diccionario2.put("triton", "insectos");

        System.out.println("Introduzca el tipo de anfibio: ");
        String tipo = sc.nextLine();
        if ((diccionario2.containsKey(tipo)) && (diccionario2.containsKey(tipo))) {
            System.out.println("Habitat: " + diccionario1.get(tipo));
            System.out.println("Alimentacion: " + diccionario2.get(tipo));
        }else {
            System.out.println("Ese tipo de anfibio no existe");
        }
    }
}
