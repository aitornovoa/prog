import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);

        System.out.println("Elige una hora de comienzo en el formato HH:mm ");
        String horaTexto = read.nextLine();
        System.out.println("Añade los minutos de duración del programa: ");
        int duracionPrograma = read.nextInt();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(horaTexto, formato);
        LocalTime horaFin = hora.plus(duracionPrograma, ChronoUnit.MINUTES);

        String horaFinalizacion = horaFin.format(formato);

        System.out.println(horaFinalizacion);

        read.close();
    }
}
