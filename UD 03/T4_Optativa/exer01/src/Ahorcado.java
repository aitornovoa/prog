import java.util.Scanner;

public class Ahorcado {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "JAVA"; // Palabra a adivinar
        String palabraAdivinada = "_".repeat(palabraSecreta.length());
        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraCompletada = false;

        System.out.println("¡Bienvenido al juego del Ahorcado!");

        while (intentos < intentosMaximos && !palabraCompletada) {
            System.out.println("\nPalabra: " + palabraAdivinada);
            System.out.println("Intentos restantes: " + (intentosMaximos - intentos));
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            if (palabraSecreta.contains(String.valueOf(letra))) {
                StringBuilder nuevaPalabraAdivinada = new StringBuilder(palabraAdivinada);
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        nuevaPalabraAdivinada.setCharAt(i, letra);
                    }
                }
                palabraAdivinada = nuevaPalabraAdivinada.toString();
            } else {
                intentos++;
                System.out.println("Letra incorrecta.");
            }

            if (palabraAdivinada.equals(palabraSecreta)) {
                palabraCompletada = true;
            }
        }

        if (palabraCompletada) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\n¡Perdiste! La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }/*/

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "JAVA"; // Palabra a adivinar
        char[] palabraAdivinada = new char[palabraSecreta.length()];
        boolean[] letrasAdivinadas = new boolean[palabraSecreta.length()];
        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraCompletada = false;

        // Inicializar palabra adivinada con guiones bajos
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }

        System.out.println("¡Bienvenido al juego del Ahorcado!");

        while (intentos < intentosMaximos && !palabraCompletada) {
            System.out.println("\nPalabra: " + String.valueOf(palabraAdivinada));
            System.out.println("Intentos restantes: " + (intentosMaximos - intentos));
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra && !letrasAdivinadas[i]) {
                    palabraAdivinada[i] = letra;
                    letrasAdivinadas[i] = true;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentos++;
                System.out.println("Letra incorrecta.");
            }

            if (String.valueOf(palabraAdivinada).equals(palabraSecreta)) {
                palabraCompletada = true;
            }
        }

        if (palabraCompletada) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\n¡Perdiste! La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "JAVA"; // Puedes cambiarla o hacerla aleatoria
        String palabraAdivinada = "_".repeat(palabraSecreta.length());
        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraCompletada = false;

        System.out.println("¡Bienvenido al juego del Ahorcado!");

        while (intentos < intentosMaximos && !palabraCompletada) {
            System.out.println("\n" + obtenerDibujo(intentos)); // Muestra el dibujo actual
            System.out.println("Palabra: " + palabraAdivinada);
            System.out.println("Intentos restantes: " + (intentosMaximos - intentos));
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            if (palabraSecreta.contains(String.valueOf(letra))) {
                StringBuilder nuevaPalabraAdivinada = new StringBuilder(palabraAdivinada);
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        nuevaPalabraAdivinada.setCharAt(i, letra);
                    }
                }
                palabraAdivinada = nuevaPalabraAdivinada.toString();
            } else {
                intentos++;
                System.out.println("Letra incorrecta.");
            }

            if (palabraAdivinada.equals(palabraSecreta)) {
                palabraCompletada = true;
            }
        }

        if (palabraCompletada) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\n" + obtenerDibujo(intentos));
            System.out.println("¡Perdiste! La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }

    // Método para obtener el dibujo ASCII usando switch-case
    public static String obtenerDibujo(int intentos) {
        switch (intentos) {
            case 1:
                return """
                   +---+
                   |   |
                   O   |
                       |
                       |
                       |
                =========
                """;
            case 2:
                return """
                   +---+
                   |   |
                   O   |
                   |   |
                       |
                       |
                =========
                """;
            case 3:
                return """
                   +---+
                   |   |
                   O   |
                  /|   |
                       |
                       |
                =========
                """;
            case 4:
                return """
                   +---+
                   |   |
                   O   |
                  /|\\  |
                       |
                       |
                =========
                """;
            case 5:
                return """
                   +---+
                   |   |
                   O   |
                  /|\\  |
                  /    |
                       |
                =========
                """;
            case 6:
                return """
                   +---+
                   |   |
                   O   |
                  /|\\  |
                  / \\  |
                       |
                =========
                """;
            default:
                return """
                   +---+
                   |   |
                       |
                       |
                       |
                       |
                =========
                """;
        }
    }
}