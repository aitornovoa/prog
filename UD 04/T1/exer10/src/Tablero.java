class Tablero {
    private int[][] tablero;  // El tablero de juego (3x3)
    private final int TAMANO = 3;  // Tamaño del tablero (3x3)

    /**
     * Constructor clase tablero, se iniciliaza el tablero
     */
    public Tablero() {
        this.tablero = new int[TAMANO][TAMANO];  
    }

    /**
     * Método para mostra el tablero
     */
    public void mostrarTablero() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                char simbolo = '-';  // Por defecto, las casillas vacías se muestran con '-'
                if (tablero[i][j] == 1) {
                    simbolo = 'X';  // Representamos al jugador 1 con 'X'
                } else if (tablero[i][j] == 2) {
                    simbolo = 'O';  // Representamos al jugador 2 con 'O'
                }
                System.out.print(simbolo + "\t");  
            }
            System.out.println();  
        }
    }

    /**
     * Método para comprobar que una celda está vacía
     * @param fila
     * @param columna
     * @return true si la casilla está vacía (se muestra con un 0), sino false
     */
    public boolean esCeldaVacia(int fila, int columna) {
        return tablero[fila][columna] == 0;  
    }

    /**
     * Método para añadir un símbolo en una celda
     * @param fila
     * @param columna
     * @param jugador si es el número 1 o 2
     */
    public void hacerMovimiento(int fila, int columna, int jugador) {
        tablero[fila][columna] = jugador; 
    }
    
    /**
     * Método para verificar si hay un ganador
     * @return true si hay ganador, sino es false
     */
    public boolean hayGananador() {
        // Comprobar filas, si  las 3 casillas de una fila son iguales y no están vacías
        for (int i = 0; i < TAMANO; i++) {
            if (tablero[i][0] != 0 && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }

        // Comprobar columnas, si las 3 casillas de una columna son iguales y no están vacías
        for (int j = 0; j < TAMANO; j++) {
            if (tablero[0][j] != 0 && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;  
            }
        }

        // Comprobar diagonal principal, si las 3 casillas de la diagonal principal son iguales y no están vacías
        if (tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }

        // Comprobar diagonal secundaria, si las 3 casillas de la diagonal secundaria son iguales y no están vacías
        if (tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;  
        }

        return false;  
    }

    /**
     * Método para comprobar si el tablero está lleno, en este caso es un empate
     * @return true si hay empate, sino es false
     */
    public boolean tableroLleno() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 0) {   // Si hay alguna casilla vacía, el tablero no está lleno
                    return false;  
                }
            }
        }
        return true;  // Si no hay ninguna casilla vacía, el tablero está lleno
    }
}
