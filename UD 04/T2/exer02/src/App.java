import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        System.out.println("Introduce tu fecha de nacimiento en dd-MM-yyyy");
        String diaNacimiento = read.nextLine();

        //Formato de la fehca
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //Fecha nacimiennto
        LocalDate nacimiento = LocalDate.parse(diaNacimiento, formato);
        //Fecha actual
        LocalDate fechaActual = LocalDate.now();

        //Calcular edad, periodo entre los años
        Period periodo = Period.between(nacimiento, fechaActual);
        System.out.println("Edad: "+periodo.getYears());

        //Cumpleaños año fechaActual
        int anhofechaActual = fechaActual.getYear();
        String cumpleanhosTexto = diaNacimiento.substring(0, 5)+"-"+anhofechaActual;
        LocalDate fechaCumpleanhos = LocalDate.parse(cumpleanhosTexto, formato);

        //Comprobar si el cumpleaños ha pasado, es hoy o cuando es
        LocalDate proximoCumple;
        if(fechaCumpleanhos.isBefore(fechaActual)){
            int periodoDias = (int)ChronoUnit.DAYS.between(fechaCumpleanhos, fechaActual);
            long periodoDias2 = fechaCumpleanhos.until(fechaActual, ChronoUnit.DAYS); //Segunda forma de hacerlo con until
            System.out.println("El cumpleaños pasó hace " + periodoDias+" días.");
            System.out.println("El cumpleaños pasó hace " + periodoDias2+" días.");
            proximoCumple = fechaCumpleanhos.plus(1, ChronoUnit.YEARS);
        }
        else if (fechaCumpleanhos.isAfter(fechaActual)){
            int periodoDias = (int)ChronoUnit.DAYS.between(fechaActual, fechaCumpleanhos);
            long periodoDias2 = fechaActual.until(fechaCumpleanhos, ChronoUnit.DAYS); //Segunda forma de hacerlo con until
            System.out.println("Faltan "+periodoDias+" días para el cumpleaños");
            System.out.println("Faltan "+periodoDias2+" días para el cumpleaños");
            proximoCumple = fechaCumpleanhos;
        }
        else{
            System.out.println("Hoy es tu cumpleaños");
            proximoCumple = fechaCumpleanhos.plus(1, ChronoUnit.YEARS);
        }

        //Imprimir el día de la semana del próximo cumpleaños
        System.out.println("El día de la semana del próximo cumpleaños es "+proximoCumple.getDayOfWeek());
        // System.out.println("El día de la semana del próximo cumpleaños es "+proximoCumple.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new java.util.Locale("es", "ES")));

        read.close();
    }
}
