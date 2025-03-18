import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import gestor.Tarea;
import gestor.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner read = new Scanner(System.in);

        //Se guardann usuarios, usando como clave su nombre de usuario
        HashMap<String, Usuario> usuarios = new HashMap<>();

        //Si está vacío, no hay usuario activo
        Optional<Usuario> usuarioActivo = Optional.empty();

        // valor salir, valor 1 menú inicioSesion, valor 2 menú usuarioActivo
        byte menu = 1;

        while (menu!=0) {
            if(menu==1){
                System.out.println("\nSELECCIONA UNA OPCIÓN");
                System.out.println("\ta) Iniciar sesión. ");
                System.out.println("\tb) Registrarse. ");
                System.out.println("\tc) Salir.");
                System.out.print("\t>");
                String opcion = read.nextLine();

                switch (opcion) {
                    case "a" -> {
                        System.out.print("\n\tIntroduce tu nombre de usuario: ");
                        String nombreUsuario = read.nextLine();
                        System.out.print("\tIntroduce tu contraseña: ");
                        String contrasenha = read.nextLine();

                        if(usuarios.containsKey(nombreUsuario)){
                            Usuario usuarioComprobar = usuarios.get(nombreUsuario);

                            if(usuarioComprobar.login(nombreUsuario, contrasenha)){
                                usuarioActivo = Optional.of(usuarioComprobar);
                                menu=2;
                                System.out.println("\t¡Bienvenido "+usuarioActivo.get().getNombrePila()+"!");
                            }
                            else{
                                System.out.println("\tCredenciales inválidas.");
                            }
                        }
                        else{
                            System.out.println("\n\tNo existe el usuario.");
                        }
                    }

                    case "b"-> {
                        System.out.print("\n\tIntroduce tu nombre de pila: ");
                        String nombrePila = read.nextLine();

                        boolean usuarioInvalido = true;
                        String nombreUsuario = new String();
                        while (usuarioInvalido) {
                            System.out.print("\tIntroduce tu nombre de usuario: ");
                            nombreUsuario = read.nextLine();
                            if(usuarios.containsKey(nombreUsuario)){
                                System.out.println("\tNombre de usuario ya existe.");
                            }
                            else{
                                usuarioInvalido = false;
                            }
                        }

                        boolean contrasenhaInvalida = true;
                        while (contrasenhaInvalida) {
                            System.out.print("\tIntroduce tu contraseña: ");
                            String contrasenha = read.nextLine();
                            System.out.print("\tRepite la contraseña: ");
                            String contrasenhaRepetida = read.nextLine();

                            if(contrasenha.equals(contrasenhaRepetida)){
                                if(Usuario.contrasenhaValida(contrasenhaRepetida)){
                                    Usuario usuario = new Usuario(nombrePila, nombreUsuario, contrasenhaRepetida);
                                    usuarios.put(nombreUsuario, usuario);
                                    System.out.println("\tUsuario añadido.");
                                    contrasenhaInvalida = false;
                                }
                                else{
                                    System.out.println("\tLa contraseña debe tener una mayúscula, una minúscula y un número como mínimo.");
                                }
                            }
                            else{
                                System.out.println("\tLas contraseñas no coinciden.");
                            }
                        }
                    }


                    case "s" -> {
                        menu=0;
                    }

                    default -> System.out.println("Opción no válida.");
                }
            }
            else if(menu==2){
                System.out.println("\nMENÚ PRINCIPAL");
                System.out.println("\ta) Modificar nombre.");
                System.out.println("\tb) Ingresar tarea pendiente.");
                System.out.println("\tc) Mostrar tareas pendientes.");
                System.out.println("\td) Marcar tarea como realizada.");
                System.out.println("\te) Mostrar tareas pendientes en las próximas 48 horas.");
                System.out.println("\tf) Mostrar tareas realizadas.");
                System.out.println("\tg) Mostrar tareas pendientes que sobrepasan fecha y hora límite.");
                System.out.println("\th) Cerrar sesión.");
                System.out.print("\t>");
                String opcion = read.nextLine();

                switch (opcion) {
                    case "a"-> {
                        System.out.print("\tIntroduce el nuevo nombre de pila: ");
                        String nuevoNombrePila = read.nextLine();
                        usuarioActivo.get().setNombrePila(nuevoNombrePila);
                        System.out.println("Nombre modificado con éxito.");
                    }

                    case "b" -> {
                        System.out.print("\n\tIntroduce el título de la tarea: ");
                        String titulo = read.nextLine();
                        System.out.print("\tIntroduce la descripción de la tarea: ");
                        String descripcion = read.nextLine();
                        System.out.print("\tIntroduce la fecha límite en el formato dd/MM/yyyy MM:hh: ");
                        String fechaLimite = read.nextLine();

                        Tarea tarea = new Tarea(titulo, descripcion, fechaLimite);

                        usuarioActivo.get().anhadirTarea(tarea);
                    }

                    case "c" -> {
                        System.out.println("\tTAREAS PENDIENTES");
                        ArrayList<Tarea> tareasPendientes = usuarioActivo.get().getTareasPendientes();
                        int indice = 1;
                        if(!tareasPendientes.isEmpty()){
                            for(Tarea t: tareasPendientes){
                                System.out.println("\t\t"+indice+") "+t.getTitulo());
                                indice++;
                            }

                            System.out.print("\tSelecciona una tarea: ");
                            int seleccion = read.nextInt()-1;
                            read.nextLine();
                            if(seleccion>=0 && seleccion<tareasPendientes.size()){
                                Tarea tareaSeleccionada = tareasPendientes.get(seleccion);
                                System.out.println("\t\tDescripción: "+tareaSeleccionada.getDescripcion());
                                System.out.println("\t\tFecha límite: "+tareaSeleccionada.getFechaLimite());
                                System.out.println("\t\tFecha de introducción: "+tareaSeleccionada.getFechaIntroduccion());
                            }
                            else{
                                System.out.println("\t\tTarea no encontrada.");
                            }
                        }
                        else{
                            System.out.println("\tNo hay tareas pendientes.");
                        }
                    }

                    case "d" -> {
                        System.out.println("\tTAREAS PENDIENTES");
                        ArrayList<Tarea> tareasPendientes = usuarioActivo.get().getTareasPendientes();
                        int indice = 1;
                        if(!tareasPendientes.isEmpty()){
                            for(Tarea t: tareasPendientes){
                                System.out.println("\t\t"+indice+") "+t.getTitulo());
                                indice++;
                            }

                            System.out.print("\tSelecciona una tarea para marcarla como hecha: ");
                            int seleccion = read.nextInt()-1;
                            read.nextLine();
                            if(seleccion>=0 && seleccion<=tareasPendientes.size()){
                                Tarea tareaSeleccionada = tareasPendientes.get(seleccion);
                                tareaSeleccionada.marcarRealizada();
                            }
                            else{
                                System.out.println("\tTarea no encontrada.");
                            }
                        }
                        else{
                            System.out.println("\tNo hay tareas pendientes.");
                        }
                    }

                    case "e" -> {
                        System.out.println("\tTAREAS PENDIENTES EN LAS PRÓXIMAS 48 HORAS");
                        ArrayList<Tarea> tareasPendientesProximas = usuarioActivo.get().getTareasProximas();
                        int indice = 1;
                        if(!tareasPendientesProximas.isEmpty()){
                            for(Tarea t: tareasPendientesProximas){
                                System.out.println("\t\t"+indice+") "+t.getTitulo());
                                indice++;
                            }

                            System.out.print("\tSelecciona una tarea: ");
                            int seleccion = read.nextInt()-1;
                            read.nextLine();
                            if(seleccion>=0 && seleccion<tareasPendientesProximas.size()){
                                Tarea tareaSeleccionada = tareasPendientesProximas.get(indice);
                                System.out.println("\t\tDescripción: "+tareaSeleccionada.getDescripcion());
                                System.out.println("\t\tFecha límite: "+tareaSeleccionada.getFechaLimite());
                                System.out.println("\t\tFecha de introducción: "+tareaSeleccionada.getFechaIntroduccion());
                            }
                            else{
                                System.out.println("\t\tTarea no encontrada.");
                            }
                        }
                        System.out.println("\tNo hay tareas pendientes para las próximas 48 horas.");
                    }

                    case "f" -> {
                        System.out.println("TAREAS REALIZADAS");
                        ArrayList<Tarea> tareasRealizadas = usuarioActivo.get().getTareasRealizadas();
                        int indice = 1;
                        if(!tareasRealizadas.isEmpty()){
                            for(Tarea t : tareasRealizadas){
                                System.out.println("\t\t"+indice+") "+t.getTitulo());
                                indice++;
                            }

                            System.out.print("Selecciona una tarea: ");
                            int seleccion = read.nextInt()-1;
                            read.nextLine();
                            if(seleccion>=0 && seleccion<tareasRealizadas.size()){
                                Tarea tareaSeleccionada = tareasRealizadas.get(seleccion);
                                System.out.println("\t\tDescripción: "+tareaSeleccionada.getDescripcion());
                                System.out.println("\t\tFecha límite: "+tareaSeleccionada.getFechaLimite());
                                System.out.println("\t\tFecha de introducción: "+tareaSeleccionada.getFechaIntroduccion());
                            }
                            else{
                                System.out.println("\t\tTarea no encontrada.");
                            }
                        }
                        else{
                            System.out.println("\tNo hay tareas realizadas.");
                        }
                    }

                    case "g" -> {
                        System.out.println("TAREAS PENDIENTES QUE SOBREPASAN LA FECHA LÍMITE");
                        ArrayList<Tarea> tareasLimiteSobrepasado = usuarioActivo.get().getTareasSobrepasadas();
                        int  indice = 1;
                        if(!tareasLimiteSobrepasado.isEmpty()){
                            for(Tarea t: tareasLimiteSobrepasado){
                                System.out.println("\t\t"+indice+") "+t.getTitulo());
                                indice++;
                            }

                            System.out.print("Selecciona una tarea: ");
                            int seleccion = read.nextInt()-1;
                            read.nextLine();

                            if(seleccion>=0 && seleccion<tareasLimiteSobrepasado.size()){
                                Tarea tareaSeleccionada = tareasLimiteSobrepasado.get(seleccion);
                                System.out.println("\t\tDescripción: "+tareaSeleccionada.getDescripcion());
                                System.out.println("\t\tFecha límite: "+tareaSeleccionada.getFechaLimite());
                                System.out.println("\t\tFecha de introducción: "+tareaSeleccionada.getFechaIntroduccion());
                            }
                            else{
                                System.out.println("\t\tTarea no encontrada.");
                            }
                        }
                        else{
                            System.out.println("\tNo hay ninguna tarea pendiente que sobrepase la fecha y hora límite.");
                        }
                    }

                    case "h" -> {
                        menu = 1;
                        usuarioActivo = Optional.empty();
                    }

                    default -> System.out.println("\tOpción no válida");
                }
            }
        }
        read.close();
    }
}