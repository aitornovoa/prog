// Pedir 3 números por pantalla e imprimir en orde de maior a menor.
// NOTA: utiliza para imprimir cada número un println distinto
import java.util.Scanner;

public class Ordenar {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Introduce el primer numero");
        int num1 = read.nextInt();
        System.out.println("Introduce el segundo numero");
        int num2 = read.nextInt();
        System.out.println("Introduce el tercero numero");
        int num3 = read.nextInt();

        int mayor, menor, medio;

        if (num1>num2 && num1>num3){
            mayor = num1;
            if(num2>num3){
                menor = num3;
                medio = num2;
            }
            else{
                menor = num2;
                medio = num3;
            }
        }
        else if (num2>num1 && num2>num3){
            mayor = num2;
            if(num1>num3){
                menor = num3;
                medio = num1;
            }
            else{
                menor = num1;
                medio = num3;
            }
        }
        else{
            mayor = num3;
            if(num1>num2){
                menor = num2;
                medio = num1;
            }
            else{
                menor = num1;
                medio = num2;
            }
        }
        System.out.println(mayor);
        System.out.println(medio);
        System.out.println(menor);

        read.close();
    }
}
