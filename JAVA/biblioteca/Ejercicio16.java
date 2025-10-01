import matematicas.funciones;

public class Ejercicio16 {
    public static void main(String[] args) {
        for(int i=1; i<=99999; i++){
            if(funciones.esCapicua(i)){
                System.out.println(" "+i);
            }
        }
    }
}