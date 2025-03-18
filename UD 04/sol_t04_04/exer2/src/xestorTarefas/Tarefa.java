package xestorTarefas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tarefa {
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String titulo; // Título da tarefa
    private String descricion; // Descircion da tarefa
    private LocalDateTime dataIntroducion; // Data de introdución
    private LocalDateTime dataLimite; // Data límite
    private boolean pendente; // Indica se está pendente ou non
    


    /**
     * Construtor de tarefa
     * @param titulo da tarefa
     * @param descricion da tarefa
     * @param dataLimite en formato "dd/MM/yyyy HH:mm"
     */
    public Tarefa (String titulo, String descricion, String dataLimite) {
        this.setTitulo(titulo);
        this.setDescricion(descricion);
        this.setDataLimite(dataLimite);
        this.setDataIntroducion();
        this.pendente = true;
    }

    /**
     * Marca a tarefa como realizada
     * Teñoa como visibilidade default para que só usuario a poida utilizar
     */
    void marcarComoRealizada() {
        this.pendente = false;
    }

    /**
     * Devolve verdadeiro se unha tarefa se debería realizar nas próximas 48 horas
     * Teñoa como visibilidade default para que só usuario a poida utilizar
     * @return
     */
    boolean isProxima() {
        if (!this.pendente) {
            return false;
        }
        // Esta e a data de detrno de 48 horas
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime proximasHoras = LocalDateTime.now().plus(48, ChronoUnit.HOURS);
        if (this.dataLimite.isBefore(proximasHoras) && this.dataLimite.isAfter(agora)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Indicanos se unha tarefa esta retrasada
     * Teñoa como visibilidade default para que só usuario a poida utilizar
     * @return
     */
    boolean nisAtrasada() {
        if (!this.pendente) {
            return false;
        }
        // Esta e a data de detrno de 48 horas
        LocalDateTime agora = LocalDateTime.now();
        if (this.dataLimite.isBefore(agora)) {
            return true;
        }
        else {
            return false;
        }
    }


    public String getTitulo() {
        return titulo;
    }


    public String getDescricion() {
        return descricion;
    }


    public String getDataIntroducion() {
        return this.dataIntroducion.format(formato);
    }


    public String getDataLimite() {
        return this.dataLimite.format(formato);
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    private void setDataIntroducion() {
        this.dataIntroducion = LocalDateTime.now();
    }

    private void setDataLimite(String dataLimite) {
        // Deberiamos comprobar con expresións regulares o formato e lanzar unha excepción se non é válido
        this.dataLimite = LocalDateTime.parse(dataLimite, formato);
    }

    public boolean isPendente() {
        return pendente;
    }

    

    

    
}
