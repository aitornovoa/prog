package pollosHermanos;

import java.time.LocalDate;

public class Reserva {

    private LocalDate fechaReserva;
    private String nombreReserva;
    private int numComensales;
   
    public Reserva(LocalDate fechaReserva, String nombreReserva, int numComensales) {
        this.fechaReserva = fechaReserva;
        this.nombreReserva = nombreReserva;
        this.numComensales = numComensales;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public int getNumComensales() {
        return numComensales;
    }

}
