import java.util.Scanner;

public class TresenRaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char[][] tablero = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
        
        char jugadorActual = 'X'; 
        boolean juegoEnCurso = true;
        int movimientos = 0;

        while (juegoEnCurso) {
            System.out.println("Tablero actual:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("[" + tablero[i][j] + "]");
                }
                System.out.println();
            }

            System.out.print("Jugador " + jugadorActual + ", introduce la fila (1-3) y la columna (1-3): ");
            int fila = scanner.nextInt() - 1;
            int columna = scanner.nextInt() - 1;

            tablero[fila][columna] = jugadorActual;
            movimientos++;

            for (int i = 0; i < 3; i++) {
                if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) ||
                    (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) {
                    System.out.println("¡Jugador " + jugadorActual + " gana!");
                    juegoEnCurso = false;
                }
            }

            if ((tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
                (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)) {
                System.out.println("¡Jugador " + jugadorActual + " gana!");
                juegoEnCurso = false;
            }

            if (movimientos == 9 && juegoEnCurso) {
                System.out.println("¡Es un empate!");
                juegoEnCurso = false;
            }

            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }

        System.out.println("Tablero final:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
    }
}