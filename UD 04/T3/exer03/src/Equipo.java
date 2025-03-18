import java.util.ArrayList;

public class Equipo {
    private String nombreEquipo;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombreEquipo){
        this.setNombreEquipo(nombreEquipo);
        this.jugadores = new ArrayList<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void anhadirJugador(Jugador jugador){
        if(jugadores.size()<10){
            boolean existeDorsal=false;

            for(Jugador aux: this.jugadores){
                if(aux.getDorsal() == jugador.getDorsal()){
                    existeDorsal = true;
                    break;
                }
            }
            if(!existeDorsal){
                this.jugadores.add(jugador);
                jugador.setEquipo(this);
            }
        }
    }

    // public int getNumJugadores(){
    //     int numJugadores=0;
    //     for(int i=0;i<jugadores.size();i++){
    //         numJugadores++;
    //     }
    //     return numJugadores;
    // }

    public Jugador getMaximoGoleador(){
        if (jugadores.isEmpty()){
            return null;
        }
        Jugador maximo = jugadores.get(0);

        for(Jugador jugador:jugadores){
            if(jugador.getNumGoles()>maximo.getNumGoles()){
                maximo=jugador;
            }
            else if (jugador.getNumGoles() == maximo.getNumGoles() && jugador.getDorsal()<maximo.getDorsal()){
                maximo = jugador;
            }
        }
        return maximo;
    }
}
