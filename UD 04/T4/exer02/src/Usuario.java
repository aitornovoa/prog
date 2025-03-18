import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario{
    private String nombre;
    private String usuario;
    private String contrasenhaHash;
    private ArrayList<Tarea> tareas;
    
    /**
     * Constructor de la clase Usuario
     * @param nombre
     * @param usuario
     * @param contrasenhaHash
     */
    public Usuario(String nombre, String usuario, String contrasenhaHash) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenhaHash = HashPassword.hashPassword(contrasenhaHash); //Se hashea la contraseña
        this.tareas = new ArrayList<>(); //Se crea un arrayList de tareas donde se irán metiendo las tareas
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenhaHash() {
        return contrasenhaHash;
    }

    public ArrayList<Tarea> getTareas(){
        return this.tareas;
    }

    /**
     * Función para verificar las credenciales
     * @param usuarioIngresado el nombre de usuario
     * @param contrasenhaIngresada la contraseña
     * @return true si coinciden, sino false
     */
    public boolean verificarCredenciales(String usuarioIngresado, String contrasenhaIngresada) {
        return this.usuario.equals(usuarioIngresado) && this.contrasenhaHash.equals(HashPassword.hashPassword(contrasenhaIngresada));
    }

    /**
     * Función estática que valida la contraseña
     * @param contrasenha
     * @return true si tiene (como mínimo) una mayúscula, una minúscula y un número; sino es false
     */
    public static boolean validarContrasenha(String contrasenha){
        boolean esMayuscula = false;
        boolean esMinuscula = false;
        boolean esDigito = false;

        for(char c: contrasenha.toCharArray()){
                if(Character.isUpperCase(c)){
                    esMayuscula = true;
                }
                if(Character.isLowerCase(c)){
                    esMinuscula = true;
                }
                if(Character.isDigit(c)){
                    esDigito = true;
                }
        }
        return esMayuscula && esMinuscula && esDigito;
    }

    /**
     * Método para añadir tareas en el arrayList de tareas
     * @param tarea
     */
    public void agregarTareas(Tarea tarea){
        this.tareas.add(tarea);
    }

    /**
     * Método para visualizar las tareas pendientes y seleccionar una de ellas
     * @param read 
     * @param formato
     */
    public void tareasPendientes(Scanner read, DateTimeFormatter formato){
        ArrayList<Tarea> tareasPendientes = new ArrayList<>();
        int indice=1;
        if(!tareas.isEmpty()){
            System.out.println("\n\tTAREAS PENDIENTES");
            for(Tarea tarea: tareas){
                if(!tarea.isFinalizada()){ //Recorro tareas y si hay una tarea que no esté finalizada, la añado a la lista de pendientes
                    tareasPendientes.add(tarea);
                    System.out.println("\t\t"+indice+") "+tarea.getTitulo());
                    indice++;
                }
            }
            if(!tareasPendientes.isEmpty()){
                seleccionarTarea(read, tareasPendientes, formato);//Llamo al método seleccionar tarea
            }
            else{
                System.out.println("\tNo hay tareas pendientes.");
            }
        }
        else{
            System.out.println("\tNo hay tareas registradas.");
            return;
        }
    }

    /**
     * Marcar como realizada una tarea seleccionada
     * @param read
     */
    public void marcarTareaRealizada(Scanner read){
        ArrayList<Tarea> tareasPendientes = new ArrayList<>();
        int indice = 1;
        if(!tareas.isEmpty()){
            System.out.println("\n\tTAREAS PENDIENTES");
            for(Tarea tarea: tareas){
                if(!tarea.isFinalizada()){ //Recorro tareas y si hay una tarea que no esté finalizada, la añado a la lista de pendientes
                    tareasPendientes.add(tarea);
                    System.out.println("\t\t"+indice+") "+tarea.getTitulo());
                    indice++;
                }
            }

            if(!tareasPendientes.isEmpty()){
                System.out.println("\n\tIntroduce el índice de la tarea a seleccionar: ");
                int indiceSeleccionar = read.nextInt()-1;
                read.nextLine();
    
                if(indiceSeleccionar>=0 && indiceSeleccionar<tareas.size()){
                    Tarea tareaSeleccionada = tareas.get(indiceSeleccionar);
                    tareaSeleccionada.marcarRealizada(); //Marco como realizada la tarea seleccionada
                    return;
                }
                else{
                    System.out.println("\tSelección inválida.");
                }
            }
            else{
                System.out.println("\tNo hay tareas pendientes");
            }

        }
        else{
            System.out.println("No hay tareas registradas.");
        }

    }

    /**
     * Muestra las tareas pendientes para las próximas 48 horas
     * @param read
     * @param formato
     */
    public void obtenerTareasPendientesProximasHoras(Scanner read, DateTimeFormatter formato){
        ArrayList<Tarea> tareasPendientesProxima = new ArrayList<>();
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime proximas48 = ahora.plusHours(48);
    
        if(!tareas.isEmpty()){
            for(Tarea tarea: tareas){
                if(!tarea.isFinalizada() && tarea.getFechaLimite().isAfter(ahora) && tarea.getFechaLimite().isBefore(proximas48)){
                    tareasPendientesProxima.add(tarea);
                }
            }
            
            if(!tareasPendientesProxima.isEmpty()){
                int indice=1;
                System.out.println("\n\tTAREAS PENDIENTES EN LAS PRÓXIMAS 48 HORAS");
                for(Tarea tarea: tareasPendientesProxima){
                    System.out.println("\t\t"+indice+") "+tarea.getTitulo());
                    indice++;
                }
                seleccionarTarea(read, tareasPendientesProxima, formato);
            }
            else{
                System.out.println("\tNo hay tareas pendientes para las próximas 48 horas.");
            }
        }
        else{
            System.out.println("\tNo hay tareas registradas");
        }
    }

    /**
     * Muestra todas las tareas marcadas como realizadas
     * @param read
     * @param formato
     */
    public void obtenerTareasRealizadas(Scanner read, DateTimeFormatter formato){
        ArrayList<Tarea> tareasRealizadas = new ArrayList<>();
        int indice = 1;
       
        if(!tareas.isEmpty()){
            for(Tarea tarea: tareas){
                if(tarea.isFinalizada()){
                    tareasRealizadas.add(tarea);
                }
            }

            if(!tareasRealizadas.isEmpty()){
                // int indice=1;
                for(Tarea tarea: tareasRealizadas){
                    System.out.println("\t\t"+indice+") "+tarea.getTitulo());
                    indice++;
                }

                seleccionarTarea(read, tareasRealizadas, formato);
            }

            else{
                System.out.println("\tNo hay ninguna tarea realizada.");
            }
        }
        else{
            System.out.println("\tNo hay tareas registradas.");
        }
    }

    /**
     * Muestra todas la tareas pendientes cuya fecha límite se haya sobrepasado
     * @param read
     * @param formato
     */
    public void mostrarTareasPendientesFechaSobrepasada(Scanner read, DateTimeFormatter formato){
        ArrayList<Tarea> tareasPendientesSobrepasadas = new ArrayList<>();
        LocalDateTime ahora = LocalDateTime.now();
        int indice=1;
        if(!tareas.isEmpty()){
            System.out.println("\n\tTAREAS PENDIENTES SOBREPASADAS");
            for(Tarea tarea: tareas){
                if(!tarea.isFinalizada() && tarea.getFechaLimite().isBefore(ahora)){
                    tareasPendientesSobrepasadas.add(tarea);
                    System.out.println("\t\t"+indice+") "+tarea.getTitulo());
                    indice++;
                }
            }
            if(!tareasPendientesSobrepasadas.isEmpty()){
                seleccionarTarea(read, tareasPendientesSobrepasadas, formato);
            }
            else{
                System.out.println("\tNo hay tareas pendientes sobrepasadas.");
            }
        }
        else{
            System.out.println("\tNo hay tareas registradas.");
        }
    }

    /**
     * Método para seleccionar una tarea pendiente
     * @param read
     * @param tareas
     * @param formato
     */
    private void seleccionarTarea(Scanner read, ArrayList<Tarea> tareas, DateTimeFormatter formato){
        System.out.print("\n\tIntroduce el índice de la tarea a seleccionar: ");
        int indiceSeleccionar = read.nextInt()-1;
        read.nextLine();
        if(indiceSeleccionar >= 0 && indiceSeleccionar < tareas.size()){
            Tarea tareaSeleccionada = tareas.get(indiceSeleccionar);
        
            System.out.print("\t\t*Título: " + tareaSeleccionada.getTitulo());
            System.out.print("\n\t\t*Descripción:" + tareaSeleccionada.getDescripcion());
            System.out.print("\n\t\t*Fecha límite: " + tareaSeleccionada.getFechaLimite().format(formato));
            System.out.print("\n\t\t*Fecha de introducción: " + tareaSeleccionada.getFechaEntrada().format(formato) + "\n");
        }
        else{
            System.out.println("\tSelección inválida.");
        }
    }
}