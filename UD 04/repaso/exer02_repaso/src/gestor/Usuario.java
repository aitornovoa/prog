package gestor;

import java.util.ArrayList;

public class Usuario{

    private String nombreUsuario;
    private String nombrePila;
    private String contrasenha;
    private ArrayList<Tarea> tareas;

    public Usuario(String nombrePila, String nombreUsuario,  String contrasenha){
        this.setNombrePila(nombrePila);
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = HashPassword.hashPassword(contrasenha);
        this.tareas = new ArrayList<Tarea>();
    }

    public boolean login(String username, String contrasenha){
        String contrasenhaHasheada = HashPassword.hashPassword(contrasenha);
        if(this.nombreUsuario.equals(username) && this.contrasenha.equals(contrasenhaHasheada)){
            return true;
        }
        else{
            return false;
        }
    }

    public void anhadirTarea(Tarea tarea){
        this.tareas.add(tarea);
    }

    public ArrayList<Tarea> getTareasPendientes(){
        ArrayList<Tarea> tareasPendientes = new ArrayList<>();
        for(Tarea t: this.tareas){
            if(t.isPendiente()){
                tareasPendientes.add(t);
            }
        }
        return tareasPendientes;
    }

    public ArrayList<Tarea> getTareasProximas(){
        ArrayList<Tarea> tareasProximas = new ArrayList<>();
        for(Tarea t: this.getTareasPendientes()){
            if(t.tareaEsProxima()){
                tareasProximas.add(t);
            }
        }
        return tareasProximas;
    }

    public ArrayList<Tarea> getTareasRealizadas(){
        ArrayList<Tarea> tareasRealizadas = new ArrayList<>();
        for(Tarea t: this.tareas){
            if(!t.isPendiente()){
                tareasRealizadas.add(t);
            }
        }
        return tareasRealizadas;
    }

    public void marcarTareaRealizada(Tarea tarea){
        tarea.marcarRealizada();
    }

    public ArrayList<Tarea> getTareasSobrepasadas(){
        ArrayList<Tarea> tareasSobrepasadas = new ArrayList<>();
        for(Tarea t: this.getTareasPendientes()){
            if(t.fechaSobrepasada()){
                tareasSobrepasadas.add(t);
            }
        }
        return tareasSobrepasadas;
    }

    public static boolean contrasenhaValida(String contrasenha){
        boolean esMayucula = false;
        boolean esMinuscula = false;
        boolean esNumero = false;

        for(int i=0;i<contrasenha.length();i++){
            char caracter = contrasenha.charAt(i);
            if(caracter>='A' && caracter<='Z'){
                esMayucula = true;
            }
            else if(caracter>='a' && caracter<='z'){
                esMinuscula = true;
            }
            else if(caracter>='0' && caracter<='9'){
                esNumero = true;
            }
        }
        return esMayucula && esMinuscula && esNumero;
    }

    

    public String getNombrePila() {
        return nombrePila;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    

}