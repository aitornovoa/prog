import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador(1, "X");
        Jugador jugador2 = new Jugador(2, "O");
        
        Jugador jugadorActual = jugador1; //Inicializo con cual jugador empiezo
        boolean juegoAcabado = false;

        while (!juegoAcabado) {

            //Mostrar el tablero
            tablero.mostrarTablero();

            // Solicitar movimiento
            System.out.println("\nJugador " + jugadorActual.getNumero() + " (" + jugadorActual.getSimbolo() + "), haz tu movimiento (fila y columna): ");
            int fila = read.nextInt();
            int columna = read.nextInt();

            // Se verifica si es válido el movimiento
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero.esCeldaVacia(fila, columna)) {
                // Realizar movimiento
                tablero.hacerMovimiento(fila, columna, jugadorActual.getNumero());

                // Verifica si hay un ganador
                if (tablero.hayGananador()) {
                    tablero.mostrarTablero();
                    System.out.println("Jugador " + jugadorActual.getNumero() + " (" + jugadorActual.getSimbolo() + ") gana!");
                    juegoAcabado = true;
                } 
                //Verifica si el tablero está lleno
                else if (tablero.tableroLleno()) {
                    tablero.mostrarTablero();
                    System.out.println("Empate!");
                    juegoAcabado = true;
                } 
                //Canbio de jugador
                else {
                    if (jugadorActual == jugador1) {
                        jugadorActual = jugador2;
                    } else {
                        jugadorActual = jugador1;
                    }
                }
            } else {
                System.out.println("Movimiento inválido. Intentalo de nuevo.");
            }
        }

        read.close();
    }
}
