import java.util.Scanner;

public class ejercicio7 {
 public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int combinacion = 6735;
    
    for (int i = 0; i < 4; i++) {
        System.out.println("Dame el codigo : ");
        int comb = s.nextInt();
        if (combinacion==comb) {
            System.out.println("La caja fuerte se ha abierto satisfactoriamente");
            i = 4;
        } else {
            System.out.println("Lo siento, esa no es la combinación");
         }
        }
    }
}