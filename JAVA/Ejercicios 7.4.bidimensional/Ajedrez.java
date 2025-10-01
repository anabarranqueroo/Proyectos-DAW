import java.util.Scanner;

public class Ajedrez {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear el tablero de ajedrez
        String[][] tablero = new String[8][8];
        
        // Inicializar el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ".";
            }
        }
        
        // Solicitar la posición del alfil
        System.out.print("Introduce la posición del alfil (ej. a1, h8): ");
        String posicion = scanner.nextLine();
        
        // Convertir la posición a coordenadas numéricas
        char columna = posicion.charAt(0);
        int fila = Character.getNumericValue(posicion.charAt(1));
        
        // Validar la posición
        if (columna < 'a' || columna > 'h' || fila < 1 || fila > 8) {
            System.out.println("Posición inválida. Debe estar entre a1 y h8.");
            scanner.close(); // Cerrar el scanner antes de salir
            return;
        }
        
        // Convertir la posición a índices del array
        int colIndex = columna - 'a'; // 'a' es 0, 'b' es 1, ..., 'h' es 7
        int filaIndex = 8 - fila; // 1 es 7, 2 es 6, ..., 8 es 0
        
        // Colocar el alfil en el tablero
        tablero[filaIndex][colIndex] = "A"; // "A" representa al alfil
        
        // Calcular las posiciones a las que puede moverse el alfil
        System.out.println("El alfil puede moverse a las siguientes posiciones:");
        
        // Diagonales hacia arriba a la derecha
        for (int i = 1; i < 8; i++) {
            if (columna + i <= 'h' && fila + i <= 8) {
                System.out.println((char)(columna + i) + "" + (fila + i));
                tablero[8 - (fila + i)][colIndex + i] = "X"; // Marca la posición
            }
        }
        
        // Diagonales hacia arriba a la izquierda
        for (int i = 1; i < 8; i++) {
            if (columna - i >= 'a' && fila + i <= 8) {
                System.out.println((char)(columna - i) + "" + (fila + i));
                tablero[8 - (fila + i)][colIndex - i] = "X"; // Marca la posición
            }
        }
        
        // Diagonales hacia abajo a la derecha
        for (int i = 1; i < 8; i++) {
            if (columna + i <= 'h' && fila - i >= 1) {
                System.out.println((char)(columna + i) + "" + (fila - i));
                tablero[8 - (fila - i)][colIndex + i] = "X"; // Marca la posición
            }
        }
        
        // Diagonales hacia abajo a la izquierda
        for (int i = 1; i < 8; i++) {
            if (columna - i >= 'a' && fila - i >= 1) {
                System.out.println((char)(columna - i) + "" + (fila - i));
                tablero[8 - (fila - i)][colIndex - i] = "X"; // Marca la posición
            }
        }
        
        // Mostrar el tablero
        System.out.println("\nTablero de ajedrez:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close(); // Cerrar el scanner al final del programa
    }
}