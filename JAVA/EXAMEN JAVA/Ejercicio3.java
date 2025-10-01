
import java.util.Scanner;
public class Ejercicio3 {
public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);

    int[][]array=new int[12][12];
    int fila, columna;
    int max=250, min=501;
    int suma=0;

    for (fila = 0; fila < 12; fila++) {
        for (columna = 0; columna < 12; columna++) {
            array[fila][columna]=((int)(Math.random()*251)+250);
            System.out.printf("%5d",array[fila][columna]);
        }
        System.out.println();
    }
    System.out.println();
    System.out.println("Diagonal desde la esquina superior izquierda a la esquina inferior derecha:");
    for (fila = 0; fila < 12; fila++) {
        int num=array[fila][fila];
        System.out.print(num+" ");
        if (num>max) {
           max=num;
        }
        if(num<min){
            min=num;
        }
        suma= suma+num;
    }
    System.out.println();
    System.out.println("Maximo: "+max);
    System.out.println("Minimo: "+min);
    System.out.println("Media: "+suma/12);
    }
}