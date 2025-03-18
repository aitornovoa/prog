import java.util.Scanner;
import java.util.ArrayList;;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pregunta> encuesta = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatosDePrueba();
        boolean activo = true;

        while (activo) {
            System.out.println("\nMENÚ");
            System.out.println("\ta) Añadir pregunta");
            System.out.println("\tb) Responder cuestionario");
            System.out.println("\tc) Mostrar resultados");
            System.out.println("\tz) Salir");
            System.out.print("\t> ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    agregarPregunta();
                    break;
                case "b":
                    responderEncuesta();
                    break;
                case "c":
                    mostrarResultados();
                    break;
                case "z":
                    activo = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }

    private static void cargarDatosDePrueba() {
        Pregunta p1 = new Pregunta("¿Hoy es lunes?");
        p1.agregarRespuestas("Sí");
        p1.agregarRespuestas("No");
        encuesta.add(p1);

        Pregunta p2 = new Pregunta("¿Cuál es tu lenguaje favorito?");
        p2.agregarRespuestas("Java");
        p2.agregarRespuestas("Python");
        p2.agregarRespuestas("C++");
        encuesta.add(p2);
    }

    private static void agregarPregunta() {
        System.out.print("Introduce la pregunta: ");
        String enunciado = scanner.nextLine();
        Pregunta nuevaPregunta = new Pregunta(enunciado);

        while (true) {
            System.out.print("Introduce una respuesta: ");
            String respuesta = scanner.nextLine();
            nuevaPregunta.agregarRespuestas(respuesta);
            if (nuevaPregunta.getNumeroRespuestas() >= 2) {
                System.out.print("¿Quieres añadir otra respuesta? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("n"))
                    break;
            } else {
                System.out.println("Debes añadir al menos otra respuesta más.");
            }
        }
        encuesta.add(nuevaPregunta);
    }

    private static void responderEncuesta() {
        for (Pregunta pregunta : encuesta) {
            pregunta.mostrarPreguntaRespuestas();
            System.out.print("Elige una opción: ");
            int eleccion = scanner.nextInt();
            scanner.nextLine();
            pregunta.responderPregunta(eleccion);
        }
    }

    private static void mostrarResultados() {
        for (Pregunta pregunta : encuesta) {
            pregunta.mostrarResultados();
            System.out.println();
        }
    }
}
