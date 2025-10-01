import java.util.Random;
import java.util.Scanner;

public class buscaminas {
    public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;
        int minas = 5;
        char[][] tablero = new char[filas][columnas];
        boolean[][] minasUbicadas = new boolean[filas][columnas];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Inicializar el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '-';
            }
        }

        // Colocar minas
        for (int i = 0; i < minas; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(filas);
                columna = random.nextInt(columnas);
            } while (minasUbicadas[fila][columna]);
            minasUbicadas[fila][columna] = true;
        }

        // Juego
        int descubiertos = 0;
        while (descubiertos < (filas * columnas - minas)) {
            System.out.println("Tablero:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }

            System.out.print("Ingresa fila y columna (0-4): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            // Validar entrada
            if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            if (minasUbicadas[fila][columna]) {
                System.out.println("¡Has perdido!");
                // Revelar el tablero
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (minasUbicadas[i][j]) {
                            tablero[i][j] = '*'; // Mostrar minas
                        }
                    }
                }
                break;
            } else {
                // Contar minas adyacentes
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue; // Saltar la celda misma
                        int nuevaFila = fila + i;
                        int nuevaColumna = columna + j;
                        if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                            if (minasUbicadas[nuevaFila][nuevaColumna]) {
                                count++;
                            }
                        }
                    }
                }
                tablero[fila][columna] = (char) (count + '0'); // Convertir el número a carácter
                descubiertos++;
            }
        }

        if (descubiertos == (filas * columnas - minas)) {
            System.out.println("¡Has ganado!");
        }

        // Mostrar el tablero final
        System.out.println("Tablero final:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}