import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import cuestionario.Pregunta;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Nesta lista alamacenamos as preguntas
        ArrayList<Pregunta> enquisa = new ArrayList<Pregunta>();

        boolean activo = true;
        while(activo) {
            // O menú
            System.out.println("Selecciona unha opción: ");
            System.out.println("\ta) Engadir pregunta");
            System.out.println("\tb) Responder cuestionario");
            System.out.println("\tc) Mostrar resultados");
            System.out.println("\tz) Sair do programa");
            System.out.print("\t> ");
            String opcion = sc.nextLine();

            switch (opcion) {

                // Engadir unha pregunta
                case "a" -> {

                    // Pedimos o enunciado das preguntas
                    System.out.print("Introduce o enunciado da pregunta: ");
                    String enunciado = sc.nextLine();
                    
                    // Creamos a nova pregunta
                    Pregunta pregunta = new Pregunta(enunciado);

                    // Engadimos preguntas ata que sexa válida a pregunta
                    while(!pregunta.isValida()) {
                        System.out.print("Introduza unha resposta: ");
                        String enunciadoResposta = sc.nextLine();
                        // Metemos unha nova resposta
                        pregunta.addRespostas(enunciadoResposta);
                    }


                    boolean seguirIntroducindo = true;
                    // Imos introducindo respostas
                    while(seguirIntroducindo) {
                        System.out.print("Desexa introducir outra resposta: s) si n) non: ");
                        String maisRespostas = sc.nextLine();

                        // O usuario decidiu introducir mais respostas
                        if (maisRespostas.equals("s")) {
                            System.out.print("Introduza unha resposta: ");
                            String enunciadoResposta = sc.nextLine();
                            // Metemos unha nova resposta
                            pregunta.addRespostas(enunciadoResposta);
                        }
                        else {
                            // O usuario decidiu saír
                            seguirIntroducindo = false;
                        }
                    }

                    // Gardamos a pregunta
                    enquisa.add(pregunta);
                }

                // Responder cuestionario
                case "b" -> {
                    for(Pregunta p: enquisa) {
                        // Imprimimos o enunciado e as respostas da pregunta
                        System.out.println(p.getEnunciado());

                        // Recorremos as respostas
                        ArrayList<String> respostas = p.getRespostas();
                        for (int i=0; i < respostas.size(); i++) {
                            // Imprimimos a resposta
                            System.out.println(i + ") " + respostas.get(i));
                        }
                        boolean respostaNonSeleccionada = true;
                        // Ata que non teñamos unha resposta seleccionada correcta seguimos preguntando
                        while(respostaNonSeleccionada) {
                            System.out.print("Selecciona unha resposta: ");
                            int numeroResposta = sc.nextInt();
                            // Indicamos que se respondeu a pregunta e indicamos cal se respondeu
                            if (numeroResposta > 0 && numeroResposta < respostas.size()) {
                                p.responderPregunta(respostas.get(numeroResposta));
                                respostaNonSeleccionada = false;
                            }
                            else System.out.print("Introduce unha resposta válida: ");
                        }
                    }
                }

                // Mostrar resultados
                case "c" -> {
                    // Recorremos todalas preguntas e respostas
                    for(Pregunta p: enquisa) {
                        System.out.println(p.getEnunciado());
                        
                        // Collemos o mapa dos String cas respostas
                        HashMap<String, Double> porcentaxes = p.getRespostaConPorcentaxe();
                        for (String resposta: porcentaxes.keySet()) {
                            double porcentaxe = porcentaxes.get(resposta);
                            System.out.println(resposta + ": " + porcentaxe);
                            
                        }
                    }
                }
                case "z" -> activo = false;
                default -> System.out.println("Introduza unha opción válida");
            }
        }

    sc.close();

}}
