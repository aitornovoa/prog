import java.util.Random;
import java.util.Scanner;
import java.util.Random.*;;

public class App2{

    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        Random random = new Random();
    
        System.out.println("Introduce la cantidad de tropas atacantes: ");
        int tropasAtacantes = read.nextInt();
        System.out.println("Introduce la cantidad de tropas defensoras: ");
        int tropasDefensoras = read.nextInt();

        int maxDados = 3;

        while(tropasDefensoras>0 && tropasAtacantes>0){
            int maxDadosDefensor = Math.min(tropasDefensoras, maxDados);
            int maxDadosAtacante = Math.min(tropasAtacantes, maxDados);

            int [] tiradasDefensor = new int[maxDadosDefensor];
            int [] tiradasAtacantes = new int[maxDadosAtacante];

            for(int i=0;i< maxDadosDefensor;i++){
                tiradasDefensor[i] = random.nextInt(6)+1;
            }

            for(int i=0;i< maxDadosAtacante;i++){
                tiradasAtacantes[i] = random.nextInt(6)+1;
            }

            ordenarDescendente(tiradasDefensor);
            ordenarDescendente(tiradasAtacantes);
        
            System.out.println("Lanzamiento dados");
            System.out.print("Defensor: ");
            imprimirArray(tiradasDefensor);
            System.out.println();
            System.out.print("Atacante: ");
            imprimirArray(tiradasAtacantes);
            System.out.println();
            System.out.println("--------------------------------------------------");

            int rondas = Math.min(maxDadosDefensor, maxDadosAtacante);

            for(int i=0;i<rondas;i++){
                if(tiradasAtacantes[i] <= tiradasDefensor[i]){
                    tropasAtacantes--;
                    System.out.println("El atacante pierde una tropa");
                }
                else{
                    tropasDefensoras--;
                    System.out.println("El defensor pierde una tropa");
                }
            }

            System.out.println("\nTropas restantes despois da rolda:");
            System.out.println("Defensor: " + tropasDefensoras + " tropas");
            System.out.println("Atacante: " + tropasAtacantes + " tropas");
            System.out.println("--------------------------------------------------");
        
        }

        System.out.println("\n=== Resultado final ===");
        if (tropasDefensoras == 0) {
            System.out.println("El atacante ganó la batalla!");
        } else {
            System.out.println("El defensor ganó a batalla!");
        }

        read.close();
    }

    private static void ordenarDescendente(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = i + 1; j < array.length-1-i; j++){
                if(array[i] < array[j+1]){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
    }

    private static void imprimirArray(int[] array){
        for(int i=0;i<array.length;i++){
            if (array[i] < 1 || array[i] > 6) {
                System.out.print("[ERROR] ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }
}