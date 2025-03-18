package pollosHermanos;

import java.time.LocalDate;

public class Reserva {
    private String nome;
    private LocalDate dia;
    private int numeroComensais;

    public Reserva(String nome, LocalDate dia, int numeroComensais) {
        this.nome = nome;
        this.dia = dia;
        this.numeroComensais = numeroComensais;
    }

    public LocalDate getDia() {
        return dia;
    }

    public int getNumeroComensais() {
        return numeroComensais;
    }
}