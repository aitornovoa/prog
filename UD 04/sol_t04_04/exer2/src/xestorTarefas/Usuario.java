package xestorTarefas;
import java.util.ArrayList;

public class Usuario {
    private String nome; // Nome de pila do usuario
    private String username; // Nome de usuario do sistema
    private String contrasinal; // Contrasinal
    private ArrayList<Tarefa> tarefas; // Lista de tarefas pendentes

    /**
     * Construtor de usuario
     * @param nome de pila
     * @param username do sistema
     * @param contrasinal do usuario
     */
    public Usuario(String nome, String username, String contrasinal) {
        this.setNome(nome);
        this.username = username;
        //TODO: Aquí habería que comprobar se o contrasinal é válido co método estático e lanzar unha excepción
        this.contrasinal = HashPassword.hashPassword(contrasinal); // O Contrasinal almacenamolo como un hash
        this.tarefas = new ArrayList<Tarefa>();
    }


    /**
     * Método que nos indica se as credenciais dun usuario son válidas
     * @param username o nome de usuario
     * @param contrasinal o contrainsal do usuario sen hahs
     * @return verdadeiro se as credenciais coinciden co usuario, falso en caso contrario
     */
    public boolean login(String username, String contrasinal) {
        String contrasinalHash = HashPassword.hashPassword(contrasinal);
        if (this.username.equals(username) && contrasinalHash.equals(this.contrasinal)) {
            return true;
        }
        return false;
    }

    /**
     * Engade unha tarefa ao usuario
     * @param tarefa a engadir
     */
    public void engadirTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    /**
     * Este é outro método que poderiamos utilizar
     * @param titulo
     * @param descricion
     * @param dataLimite
     */
    public void engadirTarefa(String titulo, String descricion, String dataLimite) {
        this.tarefas.add(new Tarefa(titulo, descricion, dataLimite));
    }


    
    /**
     * Marca unha tarefa como realizada
     * @param tarefa que se marca como realizada
     */
    public void marcarTarefaRealizada(Tarefa tarefa) {
        tarefa.marcarComoRealizada();
    }


    /**
     * Devolve unha lista cas tarefas pendentes nas seguintes 48 horas
     * @return
     */
    public ArrayList<Tarefa> getTarefasPendentes48horas() {
        // Lista na que imos almacenar todalas tarefas das próximas 48 horas
        ArrayList<Tarefa> proximasTarefas = new ArrayList<Tarefa>();

        // Coollemos todalas tarefas pendentes
        for (Tarefa tarefa: this.getTarefasPendentes()) {
            // Engadimos as tarefas das próximas 48 horas
            if(tarefa.isProxima()) {
                proximasTarefas.add(tarefa);
            }
        }
        return proximasTarefas;
    }

    /**
     * Devolve unha lista cas tarefas pendentes e que se sobrepasou a data límite
     * @return
     */
    public ArrayList<Tarefa> getTarefasRetrasadas() {
        // Creamos unha lista para meter as tarefas retrasadas
        ArrayList<Tarefa> tarefasRetrasadas = new ArrayList<Tarefa>();

        // Recorremos tódalas tarefas
        for (Tarefa tarefa: this.getTarefasPendentes()) {
            // Comprobamos se a tarefa está retrasada
            if(tarefa.isAtrasada()) {
                tarefasRetrasadas.add(tarefa);
            }
        }
        return tarefasRetrasadas;
    }

    /**
     * Comproba se un contrasinal é válido
     * @param contrasinal
     * @return
     */
    public static boolean contrasinalValido(String contrasinal) {
        // COmprobamos que teñan os tres tipos de caracteres
        boolean minuscula = false;
        boolean maiusucula = false;
        boolean numero = false;
        for (int i=0; i < contrasinal.length(); i++) {
            char letra = contrasinal.charAt(i);
            if (letra >= 65 && letra <= 90) {
                maiusucula = true;
            }
            else if (letra >= 97 && letra <= 122) {
                minuscula = true;
            }
            else if (letra >= 48 && letra <= 57) {
                numero = true;
            }
        }
        if (minuscula && maiusucula && numero) {
            return true;
        }
        return false;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public ArrayList<Tarefa> getTarefasPendentes() {
        ArrayList<Tarefa> tPendentes = new ArrayList<>();
        for(Tarefa t: this.tarefas) {
            if(! t.isPendente()) tPendentes.add(t);
        }
        return tPendentes;
    }


    public ArrayList<Tarefa> getTarefasRealizadas() {
        ArrayList<Tarefa> tRealizadas = new ArrayList<>();
        for(Tarefa t: this.tarefas) {
            if(! t.isPendente()) tRealizadas.add(t);
        }
        return tRealizadas;
    }


    
    

    
}
