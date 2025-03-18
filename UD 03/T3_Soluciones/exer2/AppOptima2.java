import java.util.Scanner;

public class AppOptima2 {
    public static void main(String[] args){

        //Entrada de datos
        Scanner sc = new Scanner(System.in);

        // Pedimos os datos
        System.out.print("Introduce o número de pasaxeiros de arriba: ");
        int numArriba = sc.nextInt();
        System.out.print("Introduce o número de pasaxeiros de abaixo: ");
        int numAbaixo = sc.nextInt();

        /* Explicación algortimo
        0 pasaxeiros -> rango 1 ( 1 rango total ) 1
        1 pasaxeiro -> rango 2 (2 rangos totais) 2, 3
        2 pasaxeiros -> rango 4 ( 3 rangos totais ), 4, 5, 6
        3 pasaxeiros -> rango 7 (4 rangos totais ) 7, 8, 9, 10
        4 pasaxeiros -> rango 11 ( 5 rangos totais) 11, 12 ,13, 14, 15
        etc.

        O número de rangos que hai en cada fila é o total de pasaxeiros + 1

        Rango incial pa 4 pasaxeiros = (rangos de 3 pasaxeiros) + ( rangos de 2 pasaxeiros) + (rangos de 1 pasaxeiro) + (rangos de 0 pasaxeiros) + 1 =
        = 4 + 3 + 2 + 1 + 1 = 11
        [O +1 é para coller o seguinte número]

        Unha vez que temos eso, so temos que sumarlle os pasaxeiros de arriba para obter o rango se nos fixamos na imaxe.

        Resumo de algortimo:
        1º Calcular o total de pasaxeiros
        2º Calcular o primeiro rango para ese total
        3º Sumarlle os de arriba para ese total
         */

        // 1º Calcular o total de pasaxeiros 
        int total = numArriba + numAbaixo;

        // 2º Calcular o primeiro rango para ese total
        // Collemos os rangos de atras
        int rango_inicial = 0;

        // Para isto hai unha fórmula: https://es.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
        rango_inicial = (total * (total + 1)) / 2;
        // Sumamos 1 para coller o seguinte rango
        rango_inicial = rango_inicial + 1;


        // Este e para os dous rangos
        int rango = rango_inicial + numArriba;
        System.out.println(rango);

        sc.close();
    }
}
