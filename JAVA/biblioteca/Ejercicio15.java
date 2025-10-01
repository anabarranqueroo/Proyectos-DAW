import matematicas.funciones;

public class Ejercicio15 {
    public static void main(String[] args) {
        for(int i=1; i<=1000; i++){
            if(funciones.esPrimo(i)){
                System.out.println(" "+i);
            }
        }
    }
}