import java.util.Scanner;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner read = new Scanner(System.in);

        boolean activo = true;
        HashMap<String, ArrayList<LocalDateTime>> fichajes = new HashMap<>();
   
        fichajes.put("54337734G", new ArrayList<>(Arrays.asList(
            LocalDateTime.of(2025, 2, 16, 8, 0), LocalDateTime.of(2025, 2, 16, 16, 0),
            LocalDateTime.of(2025, 2, 17, 9, 0), LocalDateTime.of(2025, 2, 17, 17, 30)
        )));
        
        fichajes.put("87654321B", new ArrayList<>(Arrays.asList(
            LocalDateTime.of(2025, 2, 16, 7, 30)
        )));

        while (activo) {
            System.out.println("\nSelecciona una opción: ");
            System.out.println("\ta)Fichar entrada/salida ");
            System.out.println("\tb) Comprobar salario. ");
            System.out.println("\tz) Salir. ");
            System.out.print("\t> ");
            String opcion = read.nextLine();

            switch (opcion) {
                case "a":
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    System.out.println("Introduce el DNI");
                    String dni = read.nextLine();
                    ArrayList<LocalDateTime> horas = new ArrayList<>();
                    LocalDateTime horaActual = LocalDateTime.now();
                    if(!fichajes.containsKey(dni)){
                        fichajes.put(dni, horas);
                    }
                    fichajes.get(dni).add(horaActual);
                    System.out.println("Hora registrada: "+horaActual.format(formato));

                    //Este trozo fue sólo para comprobar que se añadían bien los dnis con sus correspondientes horas de entrada y salida
                    // System.out.println("\nFICHAJES");
                    // for(Map.Entry<String, ArrayList<LocalDateTime>> entry : fichajes.entrySet()) {
                    //     System.out.println("DNI: " + entry.getKey());
                    //     System.out.println("Horas registradas: ");
                    //     for (LocalDateTime hora : entry.getValue()) {
                    //         System.out.println("  - " + hora.format(formato));
                    //     }
                    // }
                    break;
                
                case "b":
                    System.out.println("Introduce el DNI");
                    dni = read.nextLine();

                    if(!fichajes.containsKey(dni) || fichajes.get(dni).size()<2){
                        System.out.println("No hay datos para calcular el salario (el DNI no está registrado o no hay suficientes datos de entrada/salida)");
                    }

                    ArrayList<LocalDateTime> registros = fichajes.get(dni);
                    long minutosTrabajados = 0;
                    //Se asegura que haya siempre una salida con el size-1 y se salta de dos en dos (una entrada y salida)
                    for (int i = 0; i < registros.size() - 1; i += 2) {
                        minutosTrabajados += ChronoUnit.MINUTES.between(registros.get(i), registros.get(i + 1));
                    }
                    
                    double salario = (minutosTrabajados / 60.0) * 12;
                    System.out.println("Salario a percibir: " + String.format("%.2f", salario) + "€");
                    break;

                case "z":
                    activo=false;
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
