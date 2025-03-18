package pollosHermanos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

public class Restaurante{

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final int COMENSALES_MAXIMOS = 20;

    private String ciudad;
    private String telefono;
    private ArrayList<Reserva> reservas;

    public Restaurante(String ciudad, String telefono) {
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    private int verComensalesDia(LocalDate dia){
        int sumaComensales = 0;
        for(Reserva reserva: this.reservas){
            if(reserva.getFechaReserva().equals(dia)){
                sumaComensales+=reserva.getNumComensales();
            }
        }
        return sumaComensales;
    }

    public boolean sitioSuficiente(String fecha, int numComensales){
        LocalDate dia = LocalDate.parse(fecha, FORMATO);
        int comensalesDia = verComensalesDia(dia)+numComensales;
        // System.out.println("Numero comensales: "+comensalesDia);
        if(comensalesDia > Restaurante.COMENSALES_MAXIMOS){
            return false;
        }
        return true;
    }

    public void hacerReserva(String nombreReserva, String dia, int numComensales){
        if(this.sitioSuficiente(dia, numComensales)){
            LocalDate diaLC = LocalDate.parse(dia, FORMATO);
            this.reservas.add(new Reserva(diaLC, nombreReserva, numComensales));
        }
        else{
            System.out.println("No hay sitio suficiente.");
        }
    }

    public int verNumComensalesHoy(){
        return verComensalesDia(LocalDate.now());
    }

    public boolean hayReserva(LocalDate dia){
        for(Reserva reserva: reservas){
            if(reserva.getFechaReserva().equals(dia)){
                return true;
            }
        }
        return false;
    }

    public Optional<Integer> primerDiaMesLibre(){
        LocalDate diaBucle = LocalDate.now();

        int mesActual = diaBucle.getMonthValue();
        boolean esteMes = true;
        while (esteMes) {
            if(hayReserva(diaBucle)){
                diaBucle = diaBucle.plus(1, ChronoUnit.DAYS); 
                if(diaBucle.getDayOfMonth() != mesActual){
                    esteMes=false;
                } 
            }
            else return Optional.of(diaBucle.getDayOfMonth());
            
        }
        return Optional.empty();
    }

}