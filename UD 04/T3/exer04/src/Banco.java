public class Banco{
    private String nombreBanco;
    private Pais paisBanco;

    public Banco(String nombreBanco, Pais paisBanco){
        this.setNombreBanco(nombreBanco);
        this.setPaisBanco(paisBanco);
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public Pais getPaisBanco() {
        return paisBanco;
    }

    public void setPaisBanco(Pais paisBanco) {
        this.paisBanco = paisBanco;
    }

}