package ejercicios;
import java.util.Scanner;
import java.util.ArrayList;
public class ejercicio23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<piezaEj23> figuras = new ArrayList<piezaEj23>();

        figuras.add(new piezaEj23("dama", 9,1));
        figuras.add(new piezaEj23("torre", 5,2));
        figuras.add(new piezaEj23("alfil", 3,2));
        figuras.add(new piezaEj23("caballo", 2,2));
        figuras.add(new piezaEj23("peon", 1,8));

        System.out.println("Figuras capturadas por el jugador: ");

        int capturas = (int)(Math.random()*16);
        int c = 0;
        int peones = 0;

        do {
            piezaEj23 p = figuras.get((int)(Math.random()*figuras.size()));
            if (p.seCaptura()){
                p.capturar();
                System.out.println(p);
                c++;
                peones += p.getValor();
            }
        }while (c < capturas);
        System.out.println("Puntos totales: " + peones);
    }
}
