public class Respuesta {

    private String texto;
    private int votos;

    public Respuesta(String texto){
        this.texto = texto;
        this.votos = 0;
    }

    public String getTexto(){
        return texto;
    }

    public int getVotos(){
        return votos;
    }

    public void incrementarVotos(){
        this.votos++;
    }
}
