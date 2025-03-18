import java.util.Scanner;

public class TresRaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TAMANO = 3;
        int[][] tablero = new int[TAMANO][TAMANO]; 
        int jugadorActual = 1; 
        boolean juegoAcabado = false;

        while (!juegoAcabado) {
           
            // Mostrar tablero
            System.out.println("Tablero actual:");
            for (int i = 0; i < TAMANO; i++) {
                for (int j = 0; j < TAMANO; j++) {
                    char simbolo = '-';
                    if (tablero[i][j] == 1) {
                        simbolo = 'X';
                    } else if (tablero[i][j] == 2) {
                        simbolo = 'O';
                    }
                    System.out.print(simbolo + "\t");
                }
                System.out.println();
            }

            //Pedir jugador actual movimiento
            System.out.println("Jugador " + (jugadorActual == 1 ? "1" : "2") + ", haz tu movimiento (fila y columna): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            // Verificar si el movimiento es válido
            if (fila >= 0 && fila < TAMANO && columna >= 0 && columna < TAMANO && tablero[fila][columna] == 0) {
                tablero[fila][columna] = jugadorActual;

                boolean ganador = false;

                // Verificar filas
                for (int i = 0; i < TAMANO; i++) {
                    if (tablero[i][0] != 0 && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                        ganador = true;
                    }
                }

                // Verificar columnas
                for (int j = 0; j < TAMANO; j++) {
                    if (tablero[0][j] != 0 && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                        ganador = true;
                    }
                }

                // Verificar diagonales
                if (tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
                    ganador = true;
                }
                if (tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
                    ganador = true;
                }

                // Mostrar ganador
                if (ganador) {
                    System.out.println("Jugador " + (jugadorActual == 1 ? "1" : "2") + " gana!");
                    juegoAcabado = true;
                } else {
                    // Verificar si tablero está lleno (empate)
                    boolean tableroLLeno = true;
                    for (int i = 0; i < TAMANO; i++) {
                        for (int j = 0; j < TAMANO; j++) {
                            if (tablero[i][j] == 0) {
                                tableroLLeno = false;
                                break;
                            }
                        }
                        if (!tableroLLeno) {
                            break;
                        }
                    }

                    if (tableroLLeno) {
                        System.out.println("Empate!");
                        juegoAcabado = true;
                    } else {
                        // Cambiar ao outro xogador
                        jugadorActual = jugadorActual == 1 ? 2 : 1;
                    }
                }
            } else {
                System.out.println("Movimiento inválido. Inténtalo de nuovo.");
            }
        }

        // Mostrar o tablero final
        System.out.println("tablero final:");
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                char simbolo = '-';
                if (tablero[i][j] == 1) {
                    simbolo = 'X';
                } else if (tablero[i][j] == 2) {
                    simbolo = 'O';
                }
                System.out.print(simbolo + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
