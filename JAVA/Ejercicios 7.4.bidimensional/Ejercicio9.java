import java.util.Scanner;
public class Ejercicio9 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int[][]matriz=new int[12][12];

    int fila, columna;
    int capa, aux1, aux2;

    System.out.println("Matriz original:");

    for (fila = 0; fila < 12; fila++) {
        for (columna=0; columna<12; columna++) {
            matriz[fila][columna]=(int)(Math.random()*101);
            System.out.print(" \t"+matriz[fila][columna]);
        }
        System.out.println();   
    }
    System.out.println();
    System.out.println("Matriz resultado:");
    
    for (capa =0; capa<6;capa++) {
        // rota por arriba
        aux1=matriz[capa][11-capa];
        for (fila=11-capa;fila>capa;fila--){
            matriz[capa][fila]=matriz[capa][fila-1];
        }
        // rota por la derecha
        aux2 = matriz[11 - capa][11 - capa];
        for (fila = 11 - capa; fila > capa + 1; fila--) {
            matriz[fila][11 - capa] = matriz[fila - 1][11 - capa];
        }
        matriz[capa + 1][11 - capa] = aux1;
        // rota por abajo
        aux1 = matriz[11 - capa][capa];
        for (fila = capa; fila <11 -capa - 1; fila--) {
            matriz[11 - capa][fila] = matriz[11 - capa][fila + 1];
        }
        matriz[11 - capa][11 - capa -1] = aux2;
        // rota por la izquierda
        for (fila = capa; fila < 11 -capa -1; fila++) {
            matriz[fila][capa]=matriz[fila+1][capa];
        }
        matriz[11 -capa -1][capa]=aux1;
    }

    for (fila = 0; fila < 12; fila++) {
        for (columna = 0; columna < 12; columna++) {
            System.out.println(" \t"+matriz[fila][columna]);
        }
        System.out.println(); 
        
    }

    }
}