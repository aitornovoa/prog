import java.time.LocalDate;

public class Grupo {
    
    private String nombre;
    private String pais;
    private int anho;

    public Grupo(String nombre, String pais, int anho){
        this.setNombre(nombre);
        this.setPais(pais);
        this.setAnho(anho);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }
    
    public int getEdad(){
        LocalDate actual = LocalDate.now();
        return actual.getYear()- this.anho;
    }
}