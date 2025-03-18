import java.util.Scanner;

public class App {
    public static void main(String[] args){

        //Entrada de datos
        Scanner sc = new Scanner(System.in);

        //Collemos o numero
        System.out.print("Introduce un número: ");

        // Gardamos o numero que nos pasan comprobando que sexa válido
        int resultado;
        do {
            resultado = sc.nextInt();
        } while(resultado < 1 || resultado > 9999);

        // É o número de pasos necesarios para conseguir o número de Keprekar
        byte pasos = 0;

        // Realizamos o algortimo ata que atopemos o número
        while(resultado != 6174) {

            // Inicializamos este vector para gardar tódolos díxitos
            int valores[] = new int[4];
            valores[0] = resultado % 10; // Collemos as unidades
            valores[1] = (resultado / 10) % 10; // Collemos as
            valores[2] = (resultado / 100) % 10; // Collemos as centenas
            valores[3] = resultado / 1000; // Collemos as unidade de millares

            // Collemos en orde as 4 cifras de maior a menor
            int[] ordenado = new int[4];

            // Metemos no vector as cifras ordenadas de maior a menor
            // Poderiase tamén ordenar o vector utilizando o mnétodo da burbulla
            // Poño este exemplo para que vexades a utilidade por exemplo do cambio de referencias
            for(int j=0; j < ordenado.length;j++){
                int maior = -1;
                int indiceSeleccionado = -1;
                for(int i=0; i < valores.length; i++) {
                    // Buscamos a maior das cifras
                    if (valores[i] > maior) {
                        maior = valores[i];
                        indiceSeleccionado = i;
                    }
                }
                // Asignamos o maior a primeira posición
                ordenado[j] = maior;

                // Creamos o vector auxiliar
                int[] aux = new int[valores.length - 1];
                int v = 0;
                for(int i=0; i < valores.length; i++) {
                    if (i != indiceSeleccionado) {
                        aux[v] = valores[i];
                        v++;
                    }
                }
                // Cambiamos a referencia
                valores = aux;
            }

            /*
            Se descompoñemos as cifras quedanos a saguinte fórmula
            Numero Resultante -> ABCD - DCBA = A * 1000 + B * 100 + C * 10 + D - (D * 1000 + C * 100 + B * 10 + A) =
                = 1000A + 100B + 10C + D - 1000D - 100C - 10B - A =
                = 999A + 90B - 90C - 999D
            Polo tanto podemos ir restando e sumando no resultado final segundo vaian aparecendo
            */
            // Construimos o novo número
            resultado = (999 * ordenado[0]) + (90 * ordenado[1]) - (90 * ordenado[2]) - (999 * ordenado[3]);

            // E un repdigits
            if (resultado == 0) {
                pasos = -1;
            }
            else {
                pasos++;
            }

        }
        // Imprimimos o numero de pasos
        System.out.println(pasos);
        sc.close();
    }
}
