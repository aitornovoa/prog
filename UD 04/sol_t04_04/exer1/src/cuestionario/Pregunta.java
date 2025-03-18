package cuestionario;

import java.util.ArrayList;
import java.util.HashMap;

public class Pregunta {
    private static final int minimoRespostas = 2; // Número de respostas mínimo para que sexa válida
   
    private String enunciado; // Enunciado da pregunta
    private ArrayList<Resposta> respostas; // Lista cas respostas
    private boolean valida; // Indica se a pregunta é válida xa que debe ter un número mínimo de respostas

    /**
     * Inicializamos unha pregunta
     * @param enunciado
     */
    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
        this.respostas = new ArrayList<Resposta>();
        this.valida = false;
    }

    /**
     * Engadimos unha resposta
     * @param contido enunciado da resposta
     */
    public void addRespostas(String contido) {
        
        // Comprobamos se hai xa algunha resposta igual
        for (Resposta respEngadia: this.respostas) {
            if(respEngadia.eIgual(contido)) return; // Mellor debería lanzar unha excepción
        }
        
        //Creamos unha resposta e engadimola a lista de respostas
        this.respostas.add(new Resposta(contido, this));
        
        // Cando introducimos mais de duas respostas poñemos que xa é válida a pregunta
        if (valida == false && this.respostas.size() >= Pregunta.minimoRespostas) {
            this.valida = true;
        }
    }

    /**
     * Seleccionamos unha resposta da pregunta como respondida
     * @param resposta resposta seleccionada
     */
    public void responderPregunta(String resposta) {

        // TODO: Senon é válida lanzase excepción

        // Repasamos as respostas ata atopar a válida
        for(Resposta respEngadida: this.respostas) {
            if (respEngadida.eIgual(resposta)) respEngadida.seleccionarResposta();
        }
        // TODO: Deberiamos lanzar unha excepción do caso que non fora válida
    }

    /**
     * Seleccionamos unha resposta da pregunta como respondida
     * @param resposta resposta seleccionada
     */
    public void responderPregunta(Resposta resposta) {

        // TODO: Senon é válida lanzase excepción

        // Repasamos as respostas ata atopar a válida
        for(Resposta respEngadida: this.respostas) {
            if (respEngadida == resposta) respEngadida.seleccionarResposta();
        }
        // TODO: Deberiamos lanzar unha excepción do caso que non fora válida
    }

    /**
     * Devolve unha lista cas respostas da pregunta
     * @return
     */
    public ArrayList<String> getRespostas() {

        // TODO: Senon é válida lanzase excepción
        ArrayList<String> resp = new ArrayList<>();
        for(Resposta respEngadida: this.respostas) resp.add(respEngadida.getEnunciado());
        return resp;
    }


    /**
     * Devolve un dicionario con cada resposta e a súa porcentaxe de selección
     * @return
     */
    public HashMap<String, Double> getRespostaConPorcentaxe() {

        // Enviamos un HashMap con cada resposta e a súa respoectiva porcentaxe
        HashMap<String, Double> resultado = new HashMap<>();

        // Recorro as respostas
        for(Resposta r: this.respostas) {
            resultado.put(r.getEnunciado(), r.getPorcentaxe());
        }

        return resultado;

    }

    /**
     * Numero de veces que foi respondida unha pregunta
     * @return o número de veces que se respondeu a esta pregunta
     */
    int getVecesRespondida() {
        // Sumamos as veces que se seleccionou cada resposta
        int sum = 0;
        // Recorremos tódalas respostas e sumamos cantas seleccións de cada resposta hai
        for(Resposta r: this.respostas) {
            sum = sum + r.getSeleccions();
        }
        return sum;
    }

    /**
     * Indica se é válida  pregunta
     * @return
     */
    public boolean isValida() {
        return valida;
    }

    public String getEnunciado() {
        return enunciado;
    }





}
