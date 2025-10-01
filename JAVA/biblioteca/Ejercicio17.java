import java.util.Scanner;
public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Introduce un numero binario (que no empiece en 0): ");
        String n = s.next();

        int res = 0;
        int cont = 1;

        for (int i = n.length() - 1 ; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                res = res + cont;
            }
            cont = cont * 2;
        }
        System.out.printf("El numero en decimal es: %d\n", res);
            }
        }
    
