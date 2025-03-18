public class Portatil {
    
    private String modelo;
    private String numSerie;
    private Color color;
    
    public Portatil(String modelo, String numSerie, Color color) {
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
}
