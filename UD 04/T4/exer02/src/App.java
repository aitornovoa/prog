import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner read = new Scanner(System.in);
    static List<Usuario> usuarios = new ArrayList<>();
    static Usuario usuarioActual = null;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) throws Exception {
        anhadirDatos();
        menuInicio();
        
    }

    /**
     * Método para añadir datos
     */
    private static void anhadirDatos(){
        Usuario usuario1 = new Usuario("Aitor", "Aitor_PROG", "Prog1");
        Usuario usuario2 = new Usuario("Jose", "Jose_PROG", "Prog2");
        LocalDateTime fechaLimite1 = LocalDateTime.parse("24/02/2025 23:59", formato);
        LocalDateTime fechaLimite2 = LocalDateTime.parse("26/02/2025 23:59", formato);
        LocalDateTime fechaLimite3 = LocalDateTime.parse("06/03/2025 23:59", formato);
        Tarea tarea1 = new Tarea("Tarea1", "Tarea1", fechaLimite1);
        Tarea tarea2 = new Tarea("Tarea2", "Tarea2", fechaLimite2);
        Tarea tarea3 = new Tarea("Tarea3", "tarea3", fechaLimite3);
        
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuario1.agregarTareas(tarea1);
        usuario1.agregarTareas(tarea2);
        usuario2.agregarTareas(tarea1);
        usuario2.agregarTareas(tarea2);

        
    }

    /**
     * Método para mostrar el menú de inicio
     */
    private static void menuInicio(){
        boolean continuar=true;

        while (continuar) {

            // for(Usuario usuario: usuarios){
            //     System.out.println("nombre del usuario: "+usuario.getNombre());
            // }
            System.out.println("\nMENÚ DE INICIO");
            System.out.println("\ti) Iniciar sesión");
            System.out.println("\tr) Registrarse");
            System.out.println("\ts) Salir");
            System.out.print("\t>");
            String opcion = read.nextLine();
            switch (opcion) {
                case "i": 
                        iniciarSesion(); 
                        break;
                case "r": 
                        registrarUsuario(); 
                        break;
                case "s": 
                        continuar=false;
                        break;
                default: 
                        System.out.println("Opción non válida.");
            }
        }  
    }

    /**
     * Método para iniciar sesión
     */
    public static void iniciarSesion(){
        System.out.print("\n\n\tIntroduce el nombre de usuario: ");
        String nombreUsuario = read.nextLine();
        System.out.print("\tIntroduce la contraseña: ");
        String contraseña = read.nextLine();

        for(Usuario usuario: usuarios){
            if(usuario.verificarCredenciales(nombreUsuario, contraseña)){ //Verifica que el nombre de usuario y contraseña coinciden con las guardadas
                usuarioActual=usuario;
                System.out.println("\n\tBienvenido "+usuarioActual.getNombre());
                menuPrincipal();
                return;
            }
            else{
                System.out.println("\n\tEl usuario o la contraseña no existe.");
                return;
            }
        }
    }

    /**
     * Método para registrar un usuario
     */
    public static void registrarUsuario(){
        System.out.print("\n\tIntroduce el nombre: ");
        String nombre = read.nextLine();
        System.out.print("\tIntroduce el nombre de usuario: ");
        String nombreUsuario = read.nextLine();
        System.out.print("\tIntroduce la contraseña: ");
        String contrasenha = read.nextLine();
        System.out.print("\tIntroduce la contraseña de nuevo: ");
        String contrasenhaRepetida = read.nextLine();

        for(Usuario usuario: usuarios){
            if(usuario.getUsuario().equals(nombreUsuario)){
                System.out.println("\n\tEl nombre de usuario ya existe.");
                return;
            }
        }

        if(!contrasenha.equals(contrasenhaRepetida)){
            System.out.println("\n\tLas contraseñas no coinciden");
            return;
        }
        
        if (!Usuario.validarContrasenha(contrasenha)) { //Llama al método estático de usuario validarContrasenha
            System.out.println("\n\tLa contraseña debe tener una mayúscula, una minúscula y un dígito.");
            return;
        }

        usuarios.add(new Usuario(nombre, nombreUsuario, contrasenha));
        // System.out.println("\tUsuario registrado correctamente."); Este es un mensaje para comprobar que el usuario se añade bien.
    }

    /**
     * Método que llama al menú principal
     */
    private static void menuPrincipal() {
        boolean continuar=true;

        while (continuar) {
            System.out.println("\nMENÚ PRINCIPAL:");
            System.out.println("\ta) Modificar nombre");
            System.out.println("\tb) Ingresar tarea pendiente");
            System.out.println("\tc) Mostrar tareas pendientes");
            System.out.println("\td) Marcar tarea como realizada");
            System.out.println("\te) Mostrar tareas pendientes en las próximas 48 horas");
            System.out.println("\tf) Mostrar tareas realizadas");
            System.out.println("\tg) Mostrar tareas pendientes pero que sobrepasaron la fecha límite");
            System.out.println("\th) Cerrar sesión");
            System.out.print("\t>");
            String opcion = read.nextLine();
            
            switch (opcion) {
                case "a":
                    System.out.print("\n\tNombre nuevo: ");
                    String nuevoNombre = read.nextLine();
                    usuarioActual.setNombre(nuevoNombre);
                    break;

                case "b":
                    System.out.print("\n\tTítulo: ");
                    String titulo = read.nextLine();
                    System.out.print("\tDescripción: ");
                    String descripcion = read.nextLine();
                    System.out.print("\tFecha límite (dd/MM/yyyy HH:mm): ");
                    String fechaLimiteTexto = read.nextLine();
                    LocalDateTime fechaLimite = LocalDateTime.parse(fechaLimiteTexto, formato);
                    usuarioActual.agregarTareas(new Tarea(titulo, descripcion, fechaLimite));
                    break;

                case "c":
                    usuarioActual.tareasPendientes(read, formato);
                    break;

                case "d":
                    usuarioActual.marcarTareaRealizada(read);
                    break;

                case "e":
                    usuarioActual.obtenerTareasPendientesProximasHoras(read, formato);;
                    break;

                case "f":
                    usuarioActual.obtenerTareasRealizadas(read, formato);
                    break;

                case "g":
                    usuarioActual.mostrarTareasPendientesFechaSobrepasada(read, formato);
                    break;

                case "h":
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción non válida.");
            }
        }
    }
}