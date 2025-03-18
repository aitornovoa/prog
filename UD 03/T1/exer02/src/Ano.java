// Pide por pantalla a idade dunha persoa e mostra por pantalla o ano no que naceu. Considera o ano actual 2025.

import java.util.Scanner;;

public class Ano {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int anoActual = 2025;

        System.out.println("Introduce tu edad: ");
        int edad = read.nextInt();

        int anoNacimiento = anoActual-edad;
        System.out.println("Tu año de nacimiento es: "+anoNacimiento);

        read.close();
    }
}
