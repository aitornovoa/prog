// Pide un número por teclado entre 1 e 7. Indica o día da semana correspondente nesta orde: luns, martes, mércores, xoves, venres, sábado e domingo. Se o número introducido non está no rango, imprime Fora de rango.
// NOTA: Utiliza a estrutura switch.
import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Introduce un número entre 1 e 7");
        int num = read.nextInt();
        switch (num) {
            case 1: System.out.println("Lunes");
                    break;
            case 2: System.out.println("Martes");
                    break;
            case 3: System.out.println("Miercoles");
                    break;
            case 4: System.out.println("Jueves");
                    break;
            case 5: System.out.println("Viernes");
                    break;
            case 6: System.out.println("Sabado");
                    break;
            case 7: System.out.println("Domingo");
                    break;
            default: System.out.println("Fuera de rango");
                    break;
        }

        read.close();
    }
}
