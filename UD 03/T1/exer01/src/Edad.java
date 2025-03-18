// Exercicio 1. Mostra a idade que terá unha persoa dentro de 10 anos que agora mesmo ten 25 anos.

import java.util.Scanner;

public class Edad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la edad");
        int edad = sc.nextInt();
        int edadFutura = edad + 10;
        System.out.println("La edad dentro de 10 años es "+edadFutura);
        sc.close();
    }
}
