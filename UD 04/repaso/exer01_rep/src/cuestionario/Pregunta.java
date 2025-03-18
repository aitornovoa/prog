package cuestionario;

import java.util.ArrayList;
import java.util.HashMap;

public class Pregunta{
    private static final int MINIMO_RESPUESTAS = 2;

    private String pregunta;
    private ArrayList<Respuesta> respuestas;
    private boolean valida;

    public Pregunta(String pregunta){
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<Respuesta>();
        this.valida = false;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isValida() {
        return valida;
    }

    public void anhadirRespuesta(String respuesta){
        for(Respuesta respuestaAnhadida: this.respuestas){
            if(respuestaAnhadida.esIgual(respuesta)){
                return;
            }
        }

        this.respuestas.add(new Respuesta(respuesta, this));

        if(valida==false && this.respuestas.size()>= Pregunta.MINIMO_RESPUESTAS){
            this.valida = true;
        }
    }

    public void responderPregunta(String respuesta){
        for(Respuesta respuestaAnhadida: this.respuestas){
            if(respuestaAnhadida.esIgual(respuesta)){
                respuestaAnhadida.seleccionarRespuesta();
            }
        }
    }

    public ArrayList<String> getRespuestas() {
        ArrayList<String> resp = new ArrayList<>();
        for(Respuesta respuestaAnhadida: this.respuestas){
            resp.add(respuestaAnhadida.getEnunciado());
        }
        return resp;
    }

    public HashMap<String, Double> getRespuestasPorcentaje(){
        HashMap<String, Double> resultado = new HashMap<>();

        for(Respuesta r: this.respuestas){
            resultado.put(r.getEnunciado(), r.getPorcentaje());
        }
        return resultado;
    }

    public int getVecesRespondida() {
        int veces = 0;

        for(Respuesta r: this.respuestas){
            veces += r.getSelecciones();
        }
        return veces;
    }

    public boolean esValida(){
        return valida;
    }

    public String getEnunciadoPregunta(){
        return pregunta;
    }
}