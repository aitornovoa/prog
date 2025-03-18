import java.util.Optional;

public class Jugador{
    private String nombre;
    private int dorsal;
    private int numGoles;
    private Equipo equipo;

    public Jugador(String nombre, int dorsal){
        this.setNombre(nombre);
        this.setDorsal(dorsal);
        this.numGoles=0;
    }

    public String getNombre() {
        return nombre;
    }
    public int getDorsal() {
        return dorsal;
    }
    public int getNumGoles() {
        return numGoles;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDorsal(int dorsal) {
        if(this.dorsal<0 || this.dorsal>99){
            this.dorsal=99;
        }
        else{
            this.dorsal = dorsal;
        }
    }    

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void marcarGol(){
        this.numGoles++;
    }

    public boolean isLibre(){
        if(equipo==null){
            return true;
        }
        else{
            return false;
        }
    }

    public Optional<Equipo> getEquipo() {
        if(isLibre()){
            return Optional.empty();
        }
        else{
            return Optional.of(this.equipo);
        }
    }
}