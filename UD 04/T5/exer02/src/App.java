import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import pollosHermanos.Restaurante;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Almacenamos os restaurantes
        ArrayList<Restaurante> restaurantes = new ArrayList<>();

        System.out.println("Benvido a xestión de restaurantes Pollos Hermanos");

        boolean menuActivo = true;
        while (menuActivo) {
            System.out.println("a) Engadir restaurante");
            System.out.println("b) Facer unha reserva");
            System.out.println("c) Ver número de comensais do día");
            System.out.println("d) Ver primeiro día deste mes sen reservas");
            System.out.println("s) Sair.");
            String opcion = sc.nextLine();

            switch (opcion) {
                // a) Engadir restaurante
                case "a" ->  {
                    // Pedimolos datos
                    System.out.print("Indica o nome da cidade do restaurante: ");
                    String cidade = sc.nextLine();
                    System.out.print("Indica o telefono do restaurante: ");
                    String telefono = sc.nextLine();

                    // Engadimos o novo restaurante
                    restaurantes.add(new Restaurante(cidade, telefono));
                }

                //b) Facer unha reserva
                case "b" -> {
                    // Pedimos o nome da cidade
                    System.out.print("Indica o nome da cidade do restaurante: ");
                    String cidade = sc.nextLine();

                    // Collemos o obxecto do restaurante se hai un restaurante nesa cidade
                    boolean haiCidade = false;
                    Restaurante rest = null;
                    for(Restaurante r: restaurantes) {
                        if(r.getCidade().equals(cidade)) {
                            rest = r;
                            haiCidade = true;
                        }
                    }
                    // Se non hai cidade indicamolo
                    if(! haiCidade) {
                        System.out.println("Non se atopou a cidade");
                        continue;
                    }

                    // Collemos o dia e o numero de comensais
                    System.out.print("Indica o día da reserva no formato dd/mm/yyyy: ");
                    String dia = sc.nextLine();
                    System.out.print("Indica o número de comensais: ");
                    int comensais = sc.nextInt(); sc.nextLine();

                    // COmprobamos que haxa espazo suficiente
                    if(!rest.sitioSuficienteReserva(dia, comensais)) {
                        System.out.println("Non hai sitio para ese dia");
                        continue;
                    }

                    // Pedimos o nome ao cal vai a reserva
                    System.out.print("Indica a nome de quen vai a reserva: ");
                    String nome = sc.nextLine();

                    // Realizamos a reserva
                    rest.realizarReserva(nome, dia, comensais);

                }

                // c) Ver número de comensais do día
                case "c" -> {
                    // Collemos o restaurante da cidade
                    System.out.print("Indica o nome da cidade do restaurante: ");
                    String cidade = sc.nextLine();
                    boolean haiCidade = false;
                    Restaurante rest = null;
                    for(Restaurante r: restaurantes) {
                        if(r.getCidade().equals(cidade)) {
                            rest = r;
                            haiCidade = true;
                        }
                    }
                    if(! haiCidade) {
                        System.out.println("Non se atopou a cidade");
                        continue;
                    }

                    // Mostramos o número de comensais que hai hoxe
                    int comensais = rest.verNumeroComensaisHoxe();
                    System.out.println(comensais);
                }
                
                //d) Ver primeiro día deste mes sen reservas
                case "d" -> {
                    // Collemos o restaurante da cidade
                    System.out.print("Indica o nome da cidade do restaurante: ");
                    String cidade = sc.nextLine();
                    boolean haiCidade = false;
                    Restaurante rest = null;
                    for(Restaurante r: restaurantes) {
                        if(r.getCidade().equals(cidade)) {
                            rest = r;
                            haiCidade = true;
                        }
                    }
                    if(! haiCidade) {
                        System.out.println("Non se atopou a cidade");
                        continue;
                    }

                    // Collemos o próximo día deste mes sen reservas
                    Optional<Integer> dia = rest.primeiroDiaLibreDoMes();
                    // Comprobamos se existe ese día
                    if(dia.isEmpty()) System.out.println("Están tódolos días cheos");
                    else System.out.println(dia.get());
                }

                // s) Sair
                case "s" -> {
                    System.out.println("Saindo...");
                    menuActivo = false;
                }
                default -> {
                    System.out.println("Opcion incorrecta");
                }
            }
        }
        sc.close();
    }
}