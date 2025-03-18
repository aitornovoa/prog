import java.util.Scanner;

public class App {
    public static void main(String[] args){

        //Entrada de datos
        Scanner sc = new Scanner(System.in);

        // Pedimos os datos
        System.out.print("Introduce o número de pasaxeiros de arriba: ");
        int numArriba = sc.nextInt();
        System.out.print("Introduce o número de pasaxeiros de abaixo: ");
        int numAbaixo = sc.nextInt();

        /*
         * Neste algortimo imos probando tódolos rangos ata que atopemos o que coincide co noso
         */

        // O rango comeza en 0, e cada vez que fagamos unha combinacion sumamos 1
        int rango = 0;
        
        // Para manter activo o while
        boolean activo = true; 
        int total = 0; // Imos iterando primeiro para as secuencias onde o total sexa 0, despois 1
        
        while (activo) {
            
            // Imos creando os pasaxeiros de arriba con todas as posibilidades comezando de 0
            for(int arriba=0; arriba <= total; arriba++) {
                // O número de abaixo é o total menos o de arriba
                int abaixo = total - arriba;
                
                // Temos unha nova combinacion
                rango++;

                // Comprobamos se coinciden co número que introduciu o usuaio
                if (abaixo == numAbaixo && arriba == numArriba){
                    // Como coincide, imprimimos o rango
                    System.out.println(rango);
                    // Cambiamos esta variable para sair do while
                    activo = false;
                    // Saimos do bucle for
                    break;
                }
            }
            // FAcemos a seguinte combinacion para mais pasaxeiros totais
            total++;
        }
        sc.close();
    }
}
