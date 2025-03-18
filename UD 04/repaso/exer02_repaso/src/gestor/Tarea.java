package gestor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tarea {
    
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String titulo;
    private String descripcion;
    private LocalDateTime fechaIntroduccion;
    private LocalDateTime fechaLimite;
    private boolean pendiente;

    public Tarea(String titulo, String descripcion, String fechaLimite){
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setFechaLimite(fechaLimite);
        this.setFechaIntroduccion();
        this.pendiente = true;
    }

    public void marcarRealizada(){
        this.pendiente = false;
    }

    public boolean tareaEsProxima(){
        if(!this.pendiente){
            return false;
        }

        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaProxima = fechaActual.plus(48, ChronoUnit.HOURS);
        if(this.fechaLimite.isBefore(fechaProxima) && this.fechaLimite.isAfter(fechaProxima)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean fechaSobrepasada(){
        if(!this.pendiente){
            return false;
        }

        LocalDateTime fechaActual = LocalDateTime.now();
        if(this.fechaLimite.isBefore(fechaActual)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIntroduccion() {
        return fechaIntroduccion.format(formato);
    }

    private void setFechaIntroduccion() {
        this.fechaIntroduccion = LocalDateTime.now();
    }

    public String getFechaLimite() {
        return fechaLimite.format(formato);
    }

    private void setFechaLimite(String fechaLimite) {
        this.fechaLimite = LocalDateTime.parse(fechaLimite, formato);
    }

    public boolean isPendiente() {
        return pendiente;
    }
}
