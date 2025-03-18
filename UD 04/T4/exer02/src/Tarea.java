import java.time.LocalDateTime;

public class Tarea {
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaLimite;
    private LocalDateTime fechaEntrada;
    private boolean finalizada;

    /**
     * Constructor de la clase tarea
     * @param titulo
     * @param descripcion
     * @param fechaLimite
     */
    public Tarea(String titulo, String descripcion, LocalDateTime fechaLimite) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.fechaEntrada = LocalDateTime.now(); //La fecha de entrada es la de la hora a la que se crea la tarea
        this.finalizada = false; //Se marca finalizada false, estando pendiente la tarea
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    /**
     * Método para marcar como realizada una tarea
     */
    public void marcarRealizada(){
        this.finalizada=true;
    }

}
