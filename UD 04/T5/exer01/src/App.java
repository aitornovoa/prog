import pollosHermanos.Restaurante;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        ArrayList<Restaurante> restaurantes = new ArrayList<>();

        

        boolean menu = true;
        
        while (menu) {
            System.out.println("\nBIENVENIDO AL MENÚ");
            System.out.println("\ta) Añadir restaurante.");
            System.out.println("\tb) Hacer una reserva.");
            System.out.println("\tc) Ver número de comensales del día.");
            System.out.println("\td) Ver primer día del mes sin reservas.");
            System.out.println("\ts) Salir");
            System.out.print("\t>");
            String opcion = read.nextLine();

            switch (opcion) {
                case "a"->{
                    System.out.print("\n\tIntroduce la ciudad: ");
                    String nombreCiudad = read.nextLine();
                    System.out.print("\tIntroduce el número de teléfono: ");
                    String telefono = read.nextLine();

                    restaurantes.add(new Restaurante(nombreCiudad, telefono));
                }

                case "b"->{
                    System.out.print("\n\tSelecciona la ciudad: ");
                    String ciudad = read.nextLine();

                    boolean hayCiudad = false;
                    Restaurante restaurant = null;
                    for(Restaurante restaurante: restaurantes){
                        if(restaurante.getCiudad().equals(ciudad)){
                            restaurant=restaurante;
                            hayCiudad = true;
                        }
                    }

                    if(!hayCiudad){
                        System.out.println("\n\tNo hay restaurantes en esa ciudad");
                        continue;
                    }

                    System.out.print("\tIntroduce la fecha de reserva en formato dd/MM/yyyy: ");
                    String dia = read.nextLine();
                    System.out.print("\tIndica el número de comensales: ");
                    int numComensales = read.nextInt();
                    read.nextLine();

                    // if(!restaurant.sitioSuficiente(dia, numComensales)){
                    //     System.out.println("\n\tNo hay sitio suficiente");
                    //     continue;
                    // }

                    
                    System.out.print("\tIndica a nombre de quién es la reserva: ");
                    String nombreReserva = read.nextLine();

                    restaurant.hacerReserva(nombreReserva, dia, numComensales);
                }
                    
                case "c"->{
                    System.out.print("\n\tIntroduce el nombre de la ciudad: ");
                    String ciudadNombre = read.nextLine();

                    boolean hayCiudad = true;
                    Restaurante restaurant = null;
                    for(Restaurante restaurante: restaurantes){
                        if(restaurante.getCiudad().equals(ciudadNombre)){
                            hayCiudad=true;
                            restaurant = restaurante;
                        }
                    }

                    if(!hayCiudad){
                        System.out.println("\tNo hay restaurantes es en esa ciudad.");
                        continue;
                    }

                    int comensalesDiaActual = restaurant.verNumComensalesHoy();
                    System.out.println("\tNúmero de comensales del día actual: "+comensalesDiaActual); 
                }

                case "d"->{
                    System.out.print("\n\tIntroduce el nombre de la ciudad: ");
                    String ciudadNombre = read.nextLine();

                    boolean hayCiudad = true;
                    Restaurante restaurant = null;
                    for(Restaurante restaurante: restaurantes){
                        if(restaurante.getCiudad().equals(ciudadNombre)){
                            hayCiudad=true;
                            restaurant = restaurante;
                        }
                    }

                    if(!hayCiudad){
                        System.out.println("\tNo hay restaurantes es en esa ciudad.");
                        continue;
                    }

                    Optional<Integer> dia = restaurant.primerDiaMesLibre();

                    if(dia.isEmpty()){
                        System.out.println("\tNo hay días libres en el mes.");
                    }
                    else{
                        System.out.println("\tEl primer día libre del mes es el "+dia.get());
                    }
                }

                case "s"->{
                    menu=false;
                }

                default->{
                    System.out.println("Opción no válida.");
                }
                    
            }
        }
        read.close();
    }
}
