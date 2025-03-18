import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import cuestionario.Pregunta;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner read = new Scanner(System.in);

        ArrayList<Pregunta> encuesta = new ArrayList<>();


        boolean activo=true;

        while (activo) {
            System.out.println("\nSELECCIONA UNA OPCIÓN");
            System.out.println("\ta) Añadir pregunta.");
            System.out.println("\tb) Responder custionario.");
            System.out.println("\tc) Mostrar resultados.");
            System.out.print("\t>");
            String opcion = read.nextLine();

            switch (opcion) {
                case "a" -> {
                    System.out.print("\tIntroduce una pregunta: ");
                    String enunciadoPregunta = read.nextLine();

                    Pregunta pregunta = new Pregunta(enunciadoPregunta);
                    while (!pregunta.isValida()){
                        System.out.print("\tIntroduce una respuesta: ");
                        String respuesta = read.nextLine();
                        pregunta.anhadirRespuesta(respuesta);
                    }

                    boolean introducirOtraRespuesta = true;

                    while (introducirOtraRespuesta) {
                        System.out.print("\t¿Desea meter otra respuesta? (s/n)");
                        String masRespuesta = read.nextLine();
                    
                        if(masRespuesta.equals("s")){
                            System.out.print("\tIntroduce una respuesta: ");
                            String respuesta = read.nextLine();
                            pregunta.anhadirRespuesta(respuesta);
                        }
                        else{
                            introducirOtraRespuesta = false;
                        }
                    }
                    encuesta.add(pregunta);
                }

                case "b" -> {
                    for(Pregunta p: encuesta){
                        System.out.println("\t"+p.getEnunciadoPregunta());

                        ArrayList<String> respuestas = p.getRespuestas();
                        for(int i=0; i<respuestas.size(); i++){
                            System.out.println("\t"+(i+1)+") "+ respuestas.get(i));
                        }

                        boolean respuestaNoSeleccionada = true;
                        while (respuestaNoSeleccionada) {
                            System.out.print("\tSelecciona una respuesta: ");

                            int numRespuesta = read.nextInt()-1;
                            read.nextLine();

                            if(numRespuesta>=0 && numRespuesta<respuestas.size()){
                                p.responderPregunta(respuestas.get(numRespuesta));
                                respuestaNoSeleccionada = false;
                            }

                            else{
                                System.out.println("\tOpción inválida.");
                            }
                        }
                    }

                }
            
                case "c" -> {
                    for(Pregunta p: encuesta){
                        System.out.println("\t"+p.getEnunciadoPregunta());

                        HashMap<String,Double> porcentajes = p.getRespuestasPorcentaje();
                        for(String respuesta: porcentajes.keySet()) {
                            double porcentaje = porcentajes.get(respuesta);
                            System.out.println("\t\t"+respuesta + ": " + porcentaje + "%");
                        }
                    }
                }
            
                case "z" -> activo=false;

                default -> System.out.println("Introduce una opción válida");
            }
        }
    }
}
