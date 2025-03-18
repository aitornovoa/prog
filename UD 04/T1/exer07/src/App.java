import dawutils.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {      
        
        // Realizamos a suma e imprimimos o seu resultado
        Calculadora.sumar(6.0, 7.0);
        System.out.println(Calculadora.obterUltimoResultado());

        // Realizamos a multiplicacion e mostramolo por pantalla
        double multiplicacion = Calculadora.multiplicar(5, Calculadora.obterUltimoResultado());
        System.out.println(multiplicacion);

        // Realizamos a potencia
        double potencia = Calculadora.potencia(5, 6);
        System.out.println(potencia);


    }

}