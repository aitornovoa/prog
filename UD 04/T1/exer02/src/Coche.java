public class Coche{
    private String marca;
    private String modelo;
    private String color;
    private int pasajeros;

    /**
     * 
     * @param marca la marca del coche 
     * @param modelo el modelo del coche
     * @param color el color del coche
     * @param pasajeros el número de pasajeros
     */
    public Coche (String marca, String modelo, String color, int pasajeros){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.pasajeros = pasajeros;
    }

    /**
     * 
     * @param marca la marca del coche
     * @param modelo el modelo del coche
     * @param color el color del coche
     */
    public Coche(String marca, String modelo, String color){
        this(marca, modelo, color, 5);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
}