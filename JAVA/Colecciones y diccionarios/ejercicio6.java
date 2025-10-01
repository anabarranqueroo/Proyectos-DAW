import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        String usuario;
        int contraseña;
        int intentos = 3;
        boolean entra = false;

        m.put("admin", 1234);
        m.put("usuario", 123456);

        do {
            System.out.println("Introduce el nombre de usuario: ");
            usuario = sc.nextLine();
            System.out.println("Introduce la contraseña: ");
            contraseña = sc.nextInt();

            if (m.containsKey(usuario)) {
                if (m.get(usuario) == contraseña){
                    System.out.println("Has accedido al area restringida");
                    entra = true;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            }else {
                System.out.println("Usuario incorrecto");
            }
            intentos--;

            if (!entra && (intentos > 0)){
                System.out.println("Te quedan " + intentos + " intentos");
            }
        }while ((!entra) && (intentos > 0));

        if (!entra){
            System.out.println("Lo siento, no tienes acceso al area restringida.");
        }
    }
}
