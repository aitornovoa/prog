// Pide pon pantalla unha cantidade de tempo en segundos. Imprime por pantalla as súas correspondentes horas, minutos e segundos do valor introducido nesta orde e cada un nunha liña.

// NOTA: Utiliza println para imprimir os resultados.
import java.util.Scanner;

public class Transformacion {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Introduce el número de segundos");
        int segundos = read.nextInt();
        int horas = segundos / 3600;
        int segundosRestantes = segundos%3600;
        int minutos = segundosRestantes / 60;
        segundosRestantes %= 60;

        System.out.println("Horas:" +horas);
        System.out.println("Minutos:" +minutos);
        System.out.println("Segundos:" +segundosRestantes);

        read.close();
    }
}
