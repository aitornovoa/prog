import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner read = new Scanner(System.in);
        Random random = new Random();

        // Se define el tamaño del tablero
        System.out.print("Introduce el tamaño del tablero: ");
        int tamanho = read.nextInt();
        int totalMinas = tamanho;

        int [][] tablero = new int[tamanho][tamanho];
        boolean[][] minas = new boolean[tamanho][tamanho];
        boolean [][] celdasDescubiertas = new boolean[tamanho][tamanho];

        int minasColocadas = 0;

        // Colocar minas
        while(minasColocadas < totalMinas){
            int fila = random.nextInt(tamanho);
            int columna = random.nextInt(tamanho);
            if(!minas[fila][columna]){
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }

        boolean jugando = true;
        while (jugando) {
            System.out.println();
            
            // Imprimir encabezado de columnas
            System.out.print("   ");
            for(int i = 0; i < tamanho; i++){
                System.out.print("C" + i + " ");
            }
            System.out.println();

            // Imprimir el tablero
            for(int i = 0; i < tamanho; i++){
                System.out.print("F" + i + " ");
                for(int j = 0; j < tamanho; j++){
                    if (celdasDescubiertas[i][j]) {
                        System.out.print(tablero[i][j] + "  ");
                    } else {
                        System.out.print("-  ");
                    }
                }
                System.out.println();
            }

            // Pedir al usuario que ingrese una posición
            System.out.print("Introduce la fila: ");
            int fila = read.nextInt();
            
            System.out.print("Introduce la columna: ");
            int columna = read.nextInt();

            // Validar que la posición esté dentro del rango
            if(fila < 0 || fila >= tamanho || columna < 0 || columna >= tamanho){
                System.out.println("La posición está fuera de rango, escoge otra.");
                continue;
            }
            
            // Si es una mina, termina el juego
            if(minas[fila][columna]){
                System.out.println("GAME OVER!!");
                break;
            } else {
                // Contar minas adyacentes
                int contadorMinasAdyacentes = 0;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        int nuevaFila = fila + i;
                        int nuevaColumna = columna + j;

                        if(nuevaFila >= 0 && nuevaFila < tamanho && nuevaColumna >= 0 && nuevaColumna < tamanho){
                            if(minas[nuevaFila][nuevaColumna]){
                                contadorMinasAdyacentes++;
                            }
                        }
                    }
                }
                tablero[fila][columna] = contadorMinasAdyacentes;
                celdasDescubiertas[fila][columna] = true;

                // Verificar si el jugador ha ganado
                boolean victoria = true;
                for(int i = 0; i < tamanho; i++){
                    for(int j = 0; j < tamanho; j++){
                        if(!minas[i][j] && !celdasDescubiertas[i][j]){
                            victoria = false;
                        }
                    }
                }

                if(victoria){
                    System.out.println();
                    System.out.print("   ");
                    for(int i = 0; i < tamanho; i++){
                        System.out.print("C" + i + " ");
                    }
                    System.out.println();

                    for(int i = 0; i < tamanho; i++){
                        System.out.print("F" + i + " ");
                        for(int j = 0; j < tamanho; j++){
                            System.out.print(tablero[i][j] + "  ");
                        }
                        System.out.println();
                    }
                    System.out.println("WIN!");
                    jugando = false;
                }
            }
        }
        read.close();
    }
}
