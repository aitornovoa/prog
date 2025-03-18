import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner read = new Scanner(System.in);

        boolean activo = true;
        HashMap<String, Double> productos = new HashMap<>();

        while (activo) {
            System.out.println("\nSelecciona una opción: ");
            System.out.println("\ta) Añadir producto. ");
            System.out.println("\tb) Eliminar producto. ");
            System.out.println("\tc) Mostrar productos con rango de precio. ");
            System.out.println("\tz) Salir. ");
            System.out.print("\t> ");
            String opcion = read.nextLine();

            switch (opcion) {
                
                case "a":
                    System.out.println("Introduce el nombre del producto: ");
                    String nombre = read.nextLine();
                    System.out.println("Introduce el precio del producto: ");
                    double precio = read.nextDouble();
                    if(productos.containsKey(nombre)){
                        System.out.println("El producto ya existe en el inventario. Desea actualizar su precio ? ( s) si| n) no)");
                        String actualizar = read.nextLine();
                        if (actualizar.equals("s")){
                            productos.put(nombre, precio);
                        }
                        else if(!actualizar.equals("n")){
                            System.out.println("Opción incorrecta. No se hizo ninguna operación.");
                        }
                    }
                    else{
                        productos.put(nombre, precio);
                    }
                    break;
                
                case "b":
                    System.out.println("Selecciona un nombre: ");
                    ArrayList<String> claves = new ArrayList<>(productos.keySet());
                    for (int i=0; i< claves.size();i++){
                        System.out.println("\t- "+i+") "+claves.get(i));
                    }
                    System.out.println("\t> ");
                    int indiceEliminar = read.nextInt();
                    if(indiceEliminar>=0 && indiceEliminar<claves.size()){
                        productos.remove(claves.get(indiceEliminar));
                    }
                    break;

                case "c":
                    System.out.println("Introduce un precio máximo: ");
                    double precioMaximo = read.nextDouble();
                    System.out.println("Introduce un precio mínimo: ");
                    double precioMinimo = read.nextDouble();

                    System.out.println("LISTA");
                    for(Map.Entry<String, Double> entry: productos.entrySet()){
                        if(entry.getValue() >= precioMinimo && entry.getValue() <= precioMaximo){
                            System.out.println("\t"+entry.getKey());
                        }
                    }
                    break;

                case "z":
                    activo=false;
                    break;
                
                default:
                    System.out.println("Opcion inválida");
                    break;
            }
        }
    }
}
