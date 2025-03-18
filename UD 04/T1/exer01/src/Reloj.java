public class Reloj {
    private String marca;
    private String modelo;
    private double precio;
    private boolean digital;

    /**
     * 
     * @param marca La marca del reloj
     * @param modelo El modelo del reloj
     * @param precio El precio del reloj
     * @param digital Indica si es digital (true), sino es analógico (false)
     */
    
    public Reloj(String marca, String modelo, double precio, boolean digital){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.digital = digital;
    }
}
