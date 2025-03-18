import java.util.Scanner;

/*Queremos calcular o prezo dunha compra dunha froitería. Primeiro pediremos por pantalla os quilogramos comprados de mazás e despois os quilogramos de laranxas. Imprimirase por pantalla o importe a pagar. Os prezos das froitas son as seguintes:

Mazás: 3,5 €/kg
Laranxas: 1,6€/kg
NOTA: utilizade o tipo de valor double.*/

public class Compra {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        double precioManzanas = 3.5;
        double precioNaranjas = 1.6;

        System.out.println("Introduce los kilogramos de manzanas comprados: ");
        double kilosManzanas = read.nextDouble();
        System.out.println("Introduce los kilogramos de naranjas comprados: ");
        double kilosNaranjas = read.nextDouble();

        double precioTotal = precioManzanas*kilosManzanas+precioNaranjas*kilosNaranjas;
        System.out.println("El precio total es de "+precioTotal+"€");

        read.close();

    }
}
