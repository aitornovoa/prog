package dawutils;

/**
 * Clase Calculadora para realizar operacións matemáticas básicas.
 */
public class Calculadora {
    private static double ultimoResultado;

    /**
     * Suma dous números decimais e almacena o resultado.
     * @param a Primeiro número decimal.
     * @param b Segundo número decimal.
     */
    public static void sumar(double a, double b) {
        ultimoResultado = a + b;
        System.out.println("Resultado da suma: " + ultimoResultado);
    }

    /**
     * Multiplica dous números decimais e devolve o resultado.
     * @param a Primeiro número decimal.
     * @param b Segundo número decimal.
     * @return Resultado da multiplicación.
     */
    public static double multiplicar(double a, double b) {
        ultimoResultado = a * b;
        return ultimoResultado;
    }

    /**
     * Calcula a potencia dun número de forma iterativa.
     * @param base Base da potencia (entero).
     * @param expoente Expoente da potencia (entero).
     * @return Resultado da potencia.
     */
    public static int potencia(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        ultimoResultado = resultado;
        return resultado;
    }

    /**
     * Devolve o resultado da última operación realizada.
     * @return Último resultado almacenado.
     */
    public static double obterUltimoResultado() {
        return ultimoResultado;
    }
}
