import java.util.ArrayList;

public class Pregunta {

    private String pregunta;
    private ArrayList<Respuesta> respuestas;

    public Pregunta(String pregunta){
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
    }

    public void agregarRespuestas(String respuesta){
        this.respuestas.add(new Respuesta(respuesta));
    }

    public void responderPregunta(int indice){
        if(indice>=1 && indice<=respuestas.size()){
            respuestas.get(indice-1).incrementarVotos();
        }
        else{
            System.out.println("Respuesta no encontrada");
        }
    }

    public void mostrarResultados(){
        int totalVotos = 0;
        double porcentaje = 0.0;
        for(Respuesta respuesta: respuestas){
            totalVotos += respuesta.getVotos();
        }

        System.out.println(pregunta);

        for(Respuesta respuesta: respuestas){
            if(totalVotos>0){
                porcentaje = respuesta.getVotos()*100/totalVotos;
            }
            else{
                porcentaje = 0;
            }
            System.out.printf("%s: %.2f%% (%d votos)\n", respuesta.getTexto(), porcentaje, respuesta.getVotos());
        }
    }

    public void mostrarPreguntaRespuestas(){
        int indice=1;
        System.out.println(pregunta);
        for(Respuesta respuesta: respuestas){
            System.out.println(indice+") "+respuesta.getTexto());
            indice++;
        }
    }

    public int getNumeroRespuestas() {
        return respuestas.size();
    }
}
