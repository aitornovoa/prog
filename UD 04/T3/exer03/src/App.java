public class App {
    public static void main(String[] args) throws Exception {
        Jugador castolo = new Jugador("Castolo", 10);
        for(int i=0;i<5;i++){
            castolo.marcarGol();
        }
        // System.out.println("el numero de goles es "+ castolo.getNumGoles());

        Jugador ximelez = new Jugador("Ximelez", 11);
        for(int i=0;i<3;i++){
            ximelez.marcarGol();
        }
        // System.out.println("el numero de goles es "+ ximelez.getNumGoles());

        Jugador miranda = new Jugador("Miranda", 7);
        for(int i=0;i<4;i++){
            miranda.marcarGol();
        }
        // System.out.println("el numero de goles es "+ miranda.getNumGoles());

        Jugador messi = new Jugador("Messi", 10);
        for(int i=0;i<6;i++){
            messi.marcarGol();
        }
        // System.out.println("el numero de goles es "+ messi.getNumGoles());

        Equipo programacion = new Equipo("Programación");
        programacion.anhadirJugador(castolo);
        programacion.anhadirJugador(ximelez);
        programacion.anhadirJugador(miranda);
        programacion.anhadirJugador(messi);
        
        // System.out.println("El número de jugadores es "+programacion.getNumJugadores());
        
        System.out.println("El máximo goleador del equipo es "+programacion.getMaximoGoleador().getNombre());

        miranda.marcarGol();

        System.out.println("El máximo goleador del equipo es " + programacion.getMaximoGoleador().getNombre());

    }
}
