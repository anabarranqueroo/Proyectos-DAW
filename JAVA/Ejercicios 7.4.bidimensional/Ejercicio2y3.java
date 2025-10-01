import java.util.Scanner;
public class Ejercicio2y3{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int [][]array= new int [4][5];

       int columna, fila;

       int sumafila;
       int sumacolumna;
       int sumatotal=0;

       for (fila = 0; fila < 4; fila++) {
           for (columna = 0; columna < 5; columna++) {
               array[fila][columna]=((int)(Math.random()*999)+100);
           }
       }

       for (fila = 0; fila < 4; fila++) {
        sumafila=0;
           for (columna = 0; columna < 5; columna++) {
               System.out.print(array[fila][columna]+"\t");
               sumafila=sumafila+array[fila][columna];
           }
           System.out.printf("%7d\n", sumafila);
       }
          for (columna = 0; columna < 5; columna++) {
              sumacolumna=0;
              for (fila = 0; fila < 4; fila++) {
                  sumacolumna=sumacolumna+array[fila][columna];
              }
              sumatotal=sumatotal+sumacolumna;
              System.out.printf("%7d ", sumacolumna);
          }
          System.out.printf("%7d ", sumatotal);
       }

       }

    