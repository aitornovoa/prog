package cuestionario;

public class Respuesta {
    private String enunciado;
    private int selecciones;
    private Pregunta pregunta;

    public Respuesta(String enunciado, Pregunta pregunta){
        this.enunciado = enunciado;
        this.selecciones = 0;
        this.pregunta = pregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getSelecciones() {
        return selecciones;
    }

    public void seleccionarRespuesta(){
        this.selecciones++;
    }

    public double getPorcentaje(){
        return (double) this.selecciones / (double) this.pregunta.getVecesRespondida() *100;
    }

    public boolean esIgual(String enunciado){
        if(this.enunciado.equals(enunciado)) return true;
        return false;
    }
}
