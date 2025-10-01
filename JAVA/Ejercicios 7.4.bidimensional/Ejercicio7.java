import java.util.Scanner;
public class Ejercicio7 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    final int VACIO = 0;
    final int MINA = 1;
    final int TESORO = 2;
    final int INTENTO = 3;
    
    int fila;
    int columna;
    int[][] cuadrante = new int[5][4];

    for(fila = 0; fila < 3; fila++) {
        for(columna = 0; columna < 3; columna++) {
            cuadrante[fila][columna] = VACIO;
        }
    }

    int minaX = (int)(Math.random() * 5);
    int minaY = (int)(Math.random() * 4);

    cuadrante[minaX][minaY] = MINA;

    int tesoroX;
    int tesoroY;

    do {
        tesoroX = (int)(Math.random() * 5);
        tesoroY = (int)(Math.random() * 4);
    } while ((minaX == tesoroX) && (minaY == tesoroY));

    cuadrante[tesoroX][tesoroY] = TESORO;

    System.out.println("¡BUSCA EL TESORO!");
        boolean salir = false;
    String c = "";

    do {
        for(columna = 3; columna >= 0; columna--) {
            System.out.print(columna + "|");
        for(fila = 0; fila < 5; fila++) {
            if (cuadrante[fila][columna] == INTENTO) {
                System.out.print("X ");
            } else {
                System.out.print(" ");
                }
            }
        System.out.println();
        }
        System.out.println(" ----------\n 0 1 2 3 4\n");

        System.out.print("Coordenada x: ");
            fila =s.nextInt();
        System.out.print("Coordenada y: ");
            columna = s.nextInt();

        switch(cuadrante[fila][columna]) {
            case VACIO:
                cuadrante[fila][columna] = INTENTO;
                if((Math.abs(fila-minaX)<2)&&(Math.abs(columna-minaY)<2)){
                    System.out.println("Cuidado, hay una mina cerca.");
                }
            break;
            case MINA:
                System.out.println("Lo siento, has perdido.");
                    salir = true;
            break;
            case TESORO:
                System.out.println("¡Enhorabuena! ¡Has encontrado el tesoro!");
                    salir = true;
            break;
            default:
        }
    } while (!salir);

    for(columna = 3; columna >= 0; columna--) {
        System.out.print(columna + " ");
    for(fila = 0; fila < 5; fila++) {
        switch(cuadrante[fila][columna]) {
            case VACIO:
                c = " ";
            break;
            case MINA:
                c = "* ";
            break;
            case TESORO:
                c = "€ ";
            break;
            case INTENTO:
                c = "X ";
            break;
            default:
        }
            System.out.print(c);
                }
            System.out.println();
        }
    System.out.println(" ----------\n 0 1 2 3 4\n");
    }
}
