import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // 0 pasajeros = rango1     
        // 1 pasajero  = rango2, rango3
        // 2 pasajeros = rango4, rango5, rango6
        // 3 pasajeros = rango7, rango8, rango9, rango10
        // 4 pasajeros = rango11, rango12, rango13, rango14, rango15
        System.out.println("Introduce el número de pasajeros arriba");
        int numPasajerosArriba = read.nextInt();
        System.out.println("Introduce el número de pasajeros abajo");
        int numPasajerosAbajo = read.nextInt();

        int totalPasajeros = numPasajerosAbajo + numPasajerosArriba;

        int rangoInicial = 0;

        for(int i=0;i<totalPasajeros;i++){
            rangoInicial += (i+1);     
        }
        rangoInicial+=1;

        int rango = rangoInicial+numPasajerosArriba;
        System.out.println("El rango es " + rango);
    }
}
