import java.util.Scanner;
public class Ejercicio5{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int [][]array = new int[6][10];
        int filamax=0;
        int columnamax=0;
        int filamin=0;
        int columnamin=0;
        int fila, columna;
        int max=0;
        int min=9999;


        for (fila = 0; fila < 6; fila++) {
            for (columna = 0; columna < 10; columna++) {
                array[fila][columna]=(int)(Math.random()*1001);
                System.out.print(" \t"+ array[fila][columna]);
            }  
        }
        for (fila = 0; fila < 6; fila++) {
            for (columna = 0; columna < 10; columna++) {
                if (array[fila][columna]>max) {
                    max=array[fila][columna];
                    filamax=fila;
                    columnamax=columna;
                    
                } 
                if (array[fila][columna]<min) {
                    min=array[fila][columna];
                    filamin=fila;
                    columnamin=columna;
                }
            }
        }
        System.out.println();
        System.out.println("Maximo: "+max);
        System.out.println("Esta en la posicion: ["+filamax+"]["+columnamax+"]");
        System.out.println("Minimo: "+min);
        System.out.println("Esta en la posicion: ["+filamin+"]["+columnamin+"]");
    }

}
