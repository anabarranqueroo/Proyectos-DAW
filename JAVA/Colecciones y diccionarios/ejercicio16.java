package ejercicios;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<String, String>();
        diccionario.put("España","Madrid");
        diccionario.put("Portugal","Lisboa");
        diccionario.put("Francia","Paris");

        String nombrep;
        String capital;

        do {
            System.out.println("Escribe el nombre de un pais y te dire su capital: ");
            nombrep = sc.nextLine();
            if (!nombrep.equals("salir")){
                if (diccionario.keySet().contains(nombrep)){
                    System.out.println("La capital de "+nombrep+ " es "+diccionario.get(nombrep));
                }else {
                    System.out.println("No conozco la respuesta ¿Cual es la capital de "+nombrep+" ?:");
                    capital = sc.nextLine();
                    diccionario.put(nombrep, capital);
                    System.out.println("Gracias por enseñarme nuevas capitales.");
                }
            }
        }while(!nombrep.equals("salir"));
    }
}
