import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);

        boolean activo = true;
        ArrayList<String> nombres = new ArrayList<>();

        while (activo) {
            System.out.println("\nSelecciona una opcion: ");
            System.out.println("\ta) Añadir un nommbre.");
            System.out.println("\tb) Mostrar nombres.");
            System.out.println("\tc) Eliminar nombre. ");
            System.out.println("\tz) Salir.");
            System.out.print("\t>");
            String opcion = read.nextLine();

            switch (opcion) {
                case "a":
                    System.out.println("Introduce un nombre: "); 
                    String nombre = read.nextLine();
                    nombres.add(nombre);
                    break;
                    
                case "b":
                    System.out.println("Lista de nombres");
                    for (String nombreLista : nombres) {
                        System.out.println(nombreLista);
                    }
                    break;

                case "c":
                    System.out.println("Selecciona un nombre: ");
                    for(int i=0; i<nombres.size();i++){
                        System.out.println("\t- " + i +") "+nombres.get(i));
                    }
                    System.out.print("Indice: ");
                    int indiceEliminar = read.nextInt();
                    if(indiceEliminar>=0 && indiceEliminar<=nombres.size()){
                        nombres.remove(indiceEliminar);
                    }
                    break;

                case "z":
                    activo=false;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        read.close();
    }
}
