import java.util.Scanner;

public class Kaprekar {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        String numeroTexto = read.next();

        // Validación de que la entrada tiene exactamente 4 caracteres y son dígitos
        if (numeroTexto.length() != 4) {
            System.out.println("La longitud tiene que ser 4");
            System.exit(-1);
        }
        boolean esNumero = true;
        for (int i = 0; i < 4; i++) {
            char c = numeroTexto.charAt(i);
            if (c < '0' || c > '9') {
                esNumero = false;
                break;
            }
        }
        if (!esNumero) {
            System.out.println("Esto no es un numero");
            System.exit(-1);
        }

        int numero = Integer.parseInt(numeroTexto);
        int iteraciones = 0;
        boolean repdigit = true;
        char primerDigito = numeroTexto.charAt(0);

        // Comprobación de repdigit
        for (int i = 1; i < 4; i++) {
            if (numeroTexto.charAt(i) != primerDigito) {
                repdigit = false;
                break;
            }
        }

        if (numero == 6174) {
            System.out.println(0);
        } else if (repdigit) {
            System.out.println(-1);
        } else {
            String numeroActual = numeroTexto;
            while (!numeroActual.equals("6174") && iteraciones < 7) {

                // Creo un array de enteros, donde meto cada caracter de numeroActual y convirtiendolo en entero
                int[] digitos = new int[4];
                for (int i = 0; i < 4; i++) {
                    digitos[i] = numeroActual.charAt(i) - '0';
                }

                // Ordeno los dígitos en orden ascendente para conseguir el numero menor
                for (int i = 0; i < digitos.length - 1; i++) {
                    for (int j = i + 1; j < digitos.length; j++) {
                        if (digitos[i] > digitos[j]) {
                            int temp = digitos[i];
                            digitos[i] = digitos[j];
                            digitos[j] = temp;
                        }
                    }
                }
     
                String menorStr = "";
                for (int i = 0; i < 4; i++) {
                    menorStr += digitos[i];
                }
                int menor = Integer.parseInt(menorStr);

                //  Ordeno los dígitos en orden descendente para conseguir el numero mayor
                for (int i = 0; i < digitos.length - 1; i++) {
                    for (int j = i + 1; j < digitos.length; j++) {
                        if (digitos[i] < digitos[j]) {
                            int temp = digitos[i];
                            digitos[i] = digitos[j];
                            digitos[j] = temp;
                        }
                    }
                }
      
                String mayorStr = "";
                for (int i = 0; i < 4; i++) {
                    mayorStr += digitos[i];
                }
                int mayor = Integer.parseInt(mayorStr);

                // Calcular la nueva iteración
                int resultado = mayor - menor;

                // Formateo el resultado a 4 dígitos con posibles ceros a la izquierda
                numeroActual = String.format("%04d", resultado);
                iteraciones++;
            }
            System.out.println("El número de iteraciones es "+iteraciones);
        }
    
        read.close();
    }
}
