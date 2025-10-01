import java.util.Scanner;
public class Ejercicio12 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int[][]array=new int[9][9];
    int fila, columna;
    int max=2500, min=901;
    int suma=0;

    for (fila = 0; fila < 9; fila++) {
        for (columna = 0; columna < 9; columna++) {
            array[fila][columna]=((int)(Math.random()*901)+500);
            System.out.printf("%5d",array[fila][columna]);
        }
        System.out.println();
    }
    System.out.println("Diagonal desde la esquina inferior izquierda a la esquina superior derecha:");
    for (fila = 0; fila < 9; fila++) {
        int num=array[8-fila][fila];
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
    System.out.println("Media: "+suma/10);
    }
}