package matematicas;
import matematicas.varias;
public class ejerciciosarrays{
    public static String convierteEnPalotes(int n){
        int acumulador = varias.digitos(n);
        int numero = 0;

        n = matematicas.varias.voltea(n);
        for (int i = 0; i < acumulador; i++) {
          numero = n % 10;
          n=n/10;
            
            for (int j = 0; j < numero; j++) {
                System.out.print("|");
            }
            System.out.print("-"); 
        }
        System.out.print(n);
        return " ";
    }
}