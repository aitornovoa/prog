import java.util.Scanner;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner read = new Scanner(System.in);

       boolean activo=true;
       ArrayList<String> nombres = new ArrayList<>();
       ArrayList<LocalDateTime> citas = new ArrayList<>();

       nombres.add("Juan Pérez");
       citas.add(LocalDateTime.of(2025, 02, 17, 10, 0));
       nombres.add("Ana Gómez");
       citas.add(LocalDateTime.of(2025, 02, 17, 11, 0));

       while (activo) {
            System.out.println("\nSelecciona una opcion:");
            System.out.println("\ta) Añadir cita.");
            System.out.println("\tb) Eliminar cita.");
            System.out.println("\tc) Seleccionar fecha");
            System.out.println("\tz) Salir");
            System.out.print("\t>");
            String opcion = read.nextLine();

            switch (opcion) {
                case "a":
                    //Creo el patrón de la fecha
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
                    
                    //Introducir datos
                    System.out.println("Introduce un nombre: ");
                    String nombre = read.nextLine();
                    System.out.println("Introduce la fecha en formato HH:mm dd/MM/yyyy");
                    String fechaCita = read.nextLine();

                    //Convierte la fecha introducidad en tipo fecha con el patrón indicado
                    LocalDateTime cita = LocalDateTime.parse(fechaCita, formato);
                    boolean darCita = true;

                    //Si es fin de semana no se puede añadir ninguna cita y aparece un aviso de ello
                    if(cita.getDayOfWeek()== DayOfWeek.SATURDAY || cita.getDayOfWeek()== DayOfWeek.SUNDAY){
                        System.out.println("No se puede programar cita en fin de semana");
                        darCita=false;
                    }
                    //Mira que no haya citas 30 minutos antes o después
                    for(LocalDateTime citaExistente: citas){
                        long diferenciaTiempo = Math.abs(ChronoUnit.MINUTES.between(cita, citaExistente));
                        if(diferenciaTiempo<30){
                            System.out.println("No se puede programar cita 30 minutos antes o después.");
                            darCita=false;
                        }
                    }

                    //Añadir datos a las listas 
                    if(darCita){
                        nombres.add(nombre);
                        citas.add(cita);
                        
                    }
                    break;

                case "b":
                    //Creo patrón segunda fecha
                    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                    //Si la lista está vacía no hay citas para eliminar
                    if(citas.isEmpty()){
                        System.out.println("No hay citas para eliminar.");
                        break;
                    }

                    //Muestro la lista de citas
                    System.out.println("CITAS");
                    for(int i=0; i<citas.size(); i++){
                        System.out.println("\t "+i+") " +nombres.get(i)+" - " +citas.get(i).format(formato2));
                    }

                    //Introduci índice
                    System.out.println("Indice");
                    if (read.hasNextInt()) {  //Esto es para que si introduces un índice incorrecto no aparezca una excepción. Si se introduce texto aparece el aviso de que tiene que ser un número
                        int indiceEliminar = read.nextInt();
                        read.nextLine(); // Limpiar buffer
                        
                        if (indiceEliminar >= 0 && indiceEliminar < citas.size()) { //Se comprueba si el índice está dentro de los de la lista
                            nombres.remove(indiceEliminar);
                            citas.remove(indiceEliminar);
                            System.out.println("Cita eliminada correctamente.");
                        } else {
                            System.out.println("Índice no válido."); //Si se introduce un índice numérico no válido aparece este aviso.
                        }
                    } else {
                        System.out.println("Entrada no válida. Debe ser un número."); //Si se introduce un carácter no numérico aparece este aviso
                        read.nextLine(); // Limpiar entrada incorrecta
                    }
                    break;

                case "c":
                    //Patrón de fecha
                    DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    //Introducir datos
                    System.out.println("Introduce la fecha con formato dd-MM-yyyy");
                    String fechaDia = read.nextLine();
                    LocalDate diaFecha = LocalDate.parse(fechaDia, formato3); //Usé el localDate ya que no se piden horas en la fecha a introducir, sino con LocalDateTime da error
                    boolean hayCitas = false;

                    for(int i = 0; i < citas.size(); i++){
                        if (citas.get(i).toLocalDate().isEqual(diaFecha)) { 
                            System.out.println(nombres.get(i) + " - " + citas.get(i).format(DateTimeFormatter.ofPattern("HH:mm"))); 
                            hayCitas = true;
                        }
                    }
                    

                    if(!hayCitas){
                        System.out.println("No hay citas para el día ");
                    }
                    break;
                
                case "z":
                    activo=false;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
       }
       read.close();
    }
}
