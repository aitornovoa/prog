package pollosHermanos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

public class Restaurante {
    // Formato no que imos gardar os dias
    private static final DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //Numero de comensais máximos por dia
    private static final int COMENSAIS_MAXIMOS = 20;

    private String cidade;
    private String telefono;
    private ArrayList<Reserva> reservas;
    
    /**
     * Construtor de restaurante
     * @param cidade
     * @param telefono
     */
    public Restaurante(String cidade, String telefono) {
        this.cidade = cidade;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();
    }

    /**
     * A partir dun día, indica cantos comensais hai ese dia
     * @param dia
     * @return
     */
    private int verComensaisPorDia(LocalDate dia) {

        int sumaComensais = 0;
        // recorremos tódalas reservas
        for(Reserva r: this.reservas) {
            // Comprobamos que sexa ese día
            if(r.getDia().equals(dia)) {
                sumaComensais += r.getNumeroComensais();
            }
        }

        return sumaComensais;

    }

    /**
     * Indica se e posible realizar un reserva para un dia debido o limite de comensais
     * @param dia
     * @param numeroComensais
     * @return
     */
    public boolean sitioSuficienteReserva(String dia, int numeroComensais) {
        // Collemos o dia en obxecto
        LocalDate diaLC = LocalDate.parse(dia, Restaurante.formatoDia);

        // Collemos os comensais dese dia
        int sumaComensaisDia = verComensaisPorDia(diaLC);

        // Se supera os comensais máximos, indicamos falso, verdadeiro en caso contrario
        if(sumaComensaisDia > Restaurante.COMENSAIS_MAXIMOS) return false;
        return true;

    }

    /**
     * Realiza unha reserva
     * @param nome
     * @param dia
     * @param numeroComensais
     */
    public void realizarReserva(String nome, String dia, int numeroComensais) {
        // Comproba que haxa sitio suficiente
        if(this.sitioSuficienteReserva(dia, numeroComensais)) {
            // Realizamos a reserva
            LocalDate diaLC = LocalDate.parse(dia, Restaurante.formatoDia);
            this.reservas.add(new Reserva(nome, diaLC, numeroComensais));
        }
        else {
            // TODO: Debería lanzar unha excepción
        }
    }

    /**
     * Indica o numero de comensais que hai para o día actual
     * @return
     */
    public int verNumeroComensaisHoxe() {
        return verComensaisPorDia(LocalDate.now());
    }

    /**
     * Indica o primeiro dia deste mes que non hai reservas
     * @return
     */
    public Optional<Integer> primeiroDiaLibreDoMes() {
        // Collemos o dia de hoxe, pero despois iremos iterando sobre el
        LocalDate diaBucle = LocalDate.now();

        // Collemos en que mes estamos
        int esteMesNumero = diaBucle.getMonthValue();

        // Facemos un bucle para saber cando se acaba este mes
        boolean esteMes = true;
        while(esteMes) {
            // Hai reservas neste días
            if (haiReservas(diaBucle)) {
                // COllemos o día seguinte
                diaBucle = diaBucle.plus(1, ChronoUnit.DAYS);

                // Comprobamos se o dia seguinte e deste mes, se non é saimos do bucle
                if(diaBucle.getDayOfMonth() != esteMesNumero) esteMes = false;
            }
            // Devolvemos o día xa que non hai reservas
            else Optional.of(diaBucle.getDayOfMonth());
        }

        // Acabamos o mes e non hai dia libre, mandamos o Optional baleiro
        return Optional.empty();
    }

    /**
     * Comproba se para un dia hai reservas
     * @param dia
     * @return
     */
    private boolean haiReservas(LocalDate dia) {
        for(Reserva r: this.reservas) {
            if(r.getDia().equals(dia)) {
                return true;
            }
        }
        return false;
    }

    public String getCidade() {
        return cidade;
    }

}