class Jugador {
    private int numero;
    private String simbolo;

    /**
     * Constructor jugador
     * @param numero
     * @param simbolo
     */
    public Jugador(int numero, String simbolo) {
        this.numero = numero;
        this.simbolo = simbolo;
    }

    public int getNumero() {
        return numero;
    }

    public String getSimbolo() {
        return simbolo;
    }
}