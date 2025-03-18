// Este ejercicio no lo entendí muy bien, yo lo interpreté de esta forma, hay que añadir psajeros (primero arriba y luego abajo), y según la 
// cantidad total, pertenecen a un rango o a otro

import java.util.Scanner;

public class Rango {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        //Asumo que el máximo número de sitios por piso es 57, y si los pasajeros llenan los de arriba tienen que bajar abajo
        final int MAXIMO_SITIOS_PISO = 57;
        System.out.println("Introduce los turistas para el piso de arriba: ");
        int turistasArriba = read.nextInt();
        System.out.println("Introduce los turistas para el piso de abajo: ");
        int turistasAbajo = read.nextInt();
        //Cada rango está formado por 10 turistas, esa es mi relación
        int rango = 10;

        // Redistribución de turistas
        if (turistasArriba > MAXIMO_SITIOS_PISO) {
            turistasAbajo += (turistasArriba - MAXIMO_SITIOS_PISO);
            turistasArriba = MAXIMO_SITIOS_PISO;
        }

        //Calculo el total de turistas
        int totalTuristas = turistasArriba + turistasAbajo;
        
     
        //Calculo mi rango, redondeando hacia arriba
        int rangoCalculado = (totalTuristas + rango - 1) / rango;

        //Si no entran todos en el bus, aparece un aviso de que hay que llamar a otro
        if (totalTuristas>2*MAXIMO_SITIOS_PISO){
            System.out.println("Hay que llamar otro autobús!!");
        }
        System.out.println("Para " + totalTuristas + " el rango es: " + rangoCalculado); 
    }
}