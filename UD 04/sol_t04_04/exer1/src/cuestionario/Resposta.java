package cuestionario;

public class Resposta {
    private String enunciado; // Enunciado da resposta
    private int seleccions; // Número de veces que foi seleccionada a resposta
    private Pregunta pregunta; // Referencia a pregunta a cal pertence a resposta

    /**
     * Inicializamos unha resposta
     * @param enunciado da resposta
     */
    public Resposta(String enunciado, Pregunta pregunta) {
        this.enunciado = enunciado;
        this.seleccions = 0;
        this.pregunta = pregunta;
    }

    /**
     * Indicase que se selecciou esta resposta na enquisa
     * Non necesitamos que sexa público
     */
    void seleccionarResposta() {
        this.seleccions++;
    }

    /**
     * Devolve a porcentaxe de veces que se respondeu a pregunta
     * @return
     */
    double getPorcentaxe() {
        return (double) this.seleccions / (double) this.pregunta.getVecesRespondida();
    }

    /**
     *  Non necesitamos que sexa público
     * @param enunciado
     * @return
     */
    boolean eIgual(String enunciado) {
        if (this.enunciado.equals(enunciado)) return true;
        return false;
    }

    public String getEnunciado() {
        return enunciado;
    }

    int getSeleccions() {
        return seleccions;
    }

    



    
}
