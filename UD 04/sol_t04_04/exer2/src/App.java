import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import xestorTarefas.Tarefa;
import xestorTarefas.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Aqui gardamos os usuarios, como clave temos o nome de usuario para que sexa
        // doado de buscar
        HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

        // Se está baleira e que non hai usuario activo
        Optional<Usuario> usuarioActivo = Optional.empty();

        /*
         * O valor 0 é para sair
         * O menu 1 é o menú de inicio de sesión
         * O menú 2 é o menú de usuario activo
         */
        byte menu = 1;

        while (menu != 0) {
            /*
             * Menú 1: menu de inicio
             */
            if (menu == 1) {
                System.out.println("Selecciona unha opción: ");
                System.out.println("\ta) Iniciar sesión");
                System.out.println("\tb) Rexistrarse");
                System.out.println("\ts) Sair do programa");
                System.out.print("\t> ");
                String opcion = sc.nextLine();

                switch (opcion) {

                    // Indiciar sesión
                    case "a" -> {

                        // Pedimos credenciais
                        System.out.print("Introduce o nome de usuario: ");
                        String username = sc.nextLine();
                        System.out.print("Introduce o teu contrasinal: ");
                        String contrasinal = sc.nextLine();

                        // Miramos se existe o usuario no sistema
                        if (usuarios.containsKey(username)) {

                            // Collemos o usuario
                            Usuario userComprobar = usuarios.get(username);

                            // Comprobamos que o login está correcto
                            if (userComprobar.login(username, contrasinal)) {
                                usuarioActivo = Optional.of(userComprobar);
                                menu = 2; // Poñemos que se mostre o outro menú
                                System.out.println("Benvido " + usuarioActivo.get().getNome());
                            } else
                                System.out.println("As credenciais son inválidas");
                        } else
                            System.out.println("As credenciais son inválidas");

                    }

                    // Rexistrarse
                    case "b" -> {
                        // Pedimolos datos
                        System.out.print("Introduce o teu nome de pila: ");
                        String nomePila = sc.nextLine();

                        // COllemos o nome de usuario
                        boolean usuarioInvalido = true;
                        String username = new String();
                        while (usuarioInvalido) {
                            System.out.print("Introduce o nome de usuario: ");
                            username = sc.nextLine();
                            if (usuarios.containsKey(username)) {
                                System.out.println("Este usuario xa existe no sistema.");
                            } else
                                usuarioInvalido = false;
                        }

                        boolean contrasinalInvalido = true;
                        while (contrasinalInvalido) {

                            // pedimos os dous contrasinais
                            System.out.print("Introduce o teu contrasinal: ");
                            String contrasinal1 = sc.nextLine();
                            System.out.print("Introduce de novo o teu contrasinal: ");
                            String contrasinal2 = sc.nextLine();

                            // Se os dous son iguais
                            if (contrasinal1.equals(contrasinal2)) {
                                if (Usuario.contrasinalValido(contrasinal2)) {
                                    Usuario novoUsuario = new Usuario(nomePila, username, contrasinal1);
                                    usuarios.put(username, novoUsuario);
                                    System.out.println("Usuario engadido con éxito");

                                } else
                                    System.out.println("O contrasinal debe de conter minusculas, maiusculas e numeros");
                            } else
                                System.out.println("Os contrasinais non deciden");
                        }

                    }

                    // Sair
                    case "s" -> menu = 0;

                    // Opción inválida
                    default -> System.out.println("Introduza unha opción válida");
                }
            }

            /*
             * Menú 2: menu de xestion de tarefas
             */
            else if (menu == 2) {
                System.out.println("Selecciona unha opción " + usuarioActivo.get().getNome() + ": ");
                System.out.println("\ta) Modificar nome");
                System.out.println("\tb) Ingresar tarefa pendente");
                System.out.println("\tc) Mostrar tarefas pendentes");
                System.out.println("\td) Marcar tarefa como realizada");
                System.out.println("\te) Mostrar tarefas pendentes nas próximas 48 horas");
                System.out.println("\tf) Mostrar tarefas realizas");
                System.out.println("\tg) Mostrar tarefas pendentes pero que se sobrepasou a data e hora límite");
                System.out.println("\ts) Sair do programa");
                System.out.print("\t> ");
                String opcion = sc.nextLine();

                switch (opcion) {

                    // Modificar o nome de pila
                    case "a" -> {
                        // Pedimolo novo nome
                        System.out.print("Introduce o teu novo nome de pila: ");
                        String nomePila = sc.nextLine();
                        usuarioActivo.get().setNome(nomePila);
                        System.out.println("O teu nome foi modificado con éxito");
                    }

                    // Introducir tarefa
                    case "b" -> {
                        System.out.print("Introduce o titulo da tarefa: ");
                        String titulo = sc.nextLine();
                        System.out.print("Introduce a descricion da tarefa: ");
                        String descricion = sc.nextLine();
                        System.out.print("Introduce a data límite no formato dd/MM/yyyy HH:mm: ");
                        String dataLimite = sc.nextLine();

                        // Engadimos a tarefa
                        Tarefa tarefa = new Tarefa(titulo, descricion, dataLimite);
                        usuarioActivo.get().engadirTarefa(tarefa);
                        // usuarioActivo.get().engadirTarefa(titulo, descricion, dataLimite);
                    }

                    // Mostramos tarefas pendentes
                    case "c" -> {
                        // Imprimimos as tarefas con o seu título
                        System.out.println("Tarefas pendentes: ");
                        ArrayList<Tarefa> tarefasPendentes = usuarioActivo.get().getTarefasPendentes();
                        for (int i = 0; i < tarefasPendentes.size(); i++) {
                            System.out.println("\t" + i + ")" + tarefasPendentes.get(i).getTitulo());
                        }

                        // COllemos unha tarefa
                        System.out.print("\tSelecciona unha tarefa: ");
                        int tarefaSel = sc.nextInt();
                        sc.nextLine();
                        if (tarefaSel < tarefasPendentes.size() && tarefaSel > 0) {
                            // Mostramos os datos da Tarefa seleccionada
                            Tarefa tarefaSeleccionada = tarefasPendentes.get(tarefaSel);
                            System.out.println("Descrición: " + tarefaSeleccionada.getDescricion());
                            System.out.println("Data introdución: " + tarefaSeleccionada.getDataIntroducion());
                            System.out.println("Data límite: " + tarefaSeleccionada.getDataLimite());
                        } else
                            System.out.println("Non existe a tarefa seleccionada");
                    }

                    // Marcar tarefa como realizada
                    case "d" -> {
                        // Mostramos o titulo de tódalas tarefas pendentes
                        System.out.println("Tarefas pendentes: ");
                        ArrayList<Tarefa> tarefasPendentesParaMarcar = usuarioActivo.get().getTarefasPendentes();
                        for (int i = 0; i < tarefasPendentesParaMarcar.size(); i++) {
                            System.out.println("\t" + i + ")" + tarefasPendentesParaMarcar.get(i).getTitulo());
                        }

                        // pedimos unha tarefa
                        System.out.print("\tSelecciona unha tarefa: ");
                        int tarefaAMarcar = sc.nextInt();
                        sc.nextLine();

                        // Se a tarefa é válida marcamola como realizada
                        if (tarefaAMarcar < tarefasPendentesParaMarcar.size() && tarefaAMarcar > 0) {
                            Tarefa tarefaSeleccionada = tarefasPendentesParaMarcar.get(tarefaAMarcar);
                            usuarioActivo.get().marcarTarefaRealizada(tarefaSeleccionada);
                        } else
                            System.out.println("Non existe a tarefa seleccionada");
                    }

                    // Mostramos tarefas pendentes nas próximas 48 horas
                    case "e" -> {
                        // Mostramos os titulos de todalas tarefas pendentes nas próximas 24 horas
                        System.out.println("Tarefas pendentes nas proximas 48 horas: ");
                        ArrayList<Tarefa> tarefas48 = usuarioActivo.get().getTarefasPendentes48horas();
                        for (int i = 0; i < tarefas48.size(); i++) {
                            System.out.println("\t" + i + ")" + tarefas48.get(i).getTitulo());
                        }

                        // pedimos que se selecciona unha tarefa
                        System.out.print("\tSelecciona unha tarefa: ");
                        int tarefaSel48 = sc.nextInt();
                        sc.nextLine();
                        if (tarefaSel48 < tarefas48.size() && tarefaSel48 > 0) {
                            Tarefa tarefaSeleccionada = tarefas48.get(tarefaSel48);
                            System.out.println("Descrición: " + tarefaSeleccionada.getDescricion());
                            System.out.println("Data introdución: " + tarefaSeleccionada.getDataIntroducion());
                            System.out.println("Data límite: " + tarefaSeleccionada.getDataLimite());
                        } else {
                            System.out.println("Non existe a tarefa seleccionada");
                        }
                    }

                    // Mostramos tarefas realizadas
                    case "f" -> {
                        System.out.println("Tarefas realizadas: ");
                        ArrayList<Tarefa> tarefasRealizadas = usuarioActivo.get().getTarefasRealizadas();
                        for (int i = 0; i < tarefasRealizadas.size(); i++) {
                            System.out.println("\t" + i + ")" + tarefasRealizadas.get(i).getTitulo());
                        }
                        // Seleccionamos unha tarefa
                        System.out.print("\tSelecciona unha tarefa: ");
                        int tarefaRel = sc.nextInt();
                        sc.nextLine();

                        // Mostramos tarefa
                        if (tarefaRel < tarefasRealizadas.size() && tarefaRel > 0) {
                            Tarefa tarefaSeleccionada = tarefasRealizadas.get(tarefaRel);
                            System.out.println("Descrición: " + tarefaSeleccionada.getDescricion());
                            System.out.println("Data introdución: " + tarefaSeleccionada.getDataIntroducion());
                            System.out.println("Data límite: " + tarefaSeleccionada.getDataLimite());
                        } else
                            System.out.println("Non existe a tarefa seleccionada");
                    }

                    // Mostramos tarefas atrasadas
                    case "g" -> {
                        System.out.println("Tarefas atrasadas: ");
                        ArrayList<Tarefa> tarefasAtrasadas = usuarioActivo.get().getTarefasRetrasadas();
                        for (int i = 0; i < tarefasAtrasadas.size(); i++) {
                            System.out.println("\t" + i + ")" + tarefasAtrasadas.get(i).getTitulo());
                        }
                        System.out.print("\tSelecciona unha tarefa: ");
                        int tarefaRet = sc.nextInt(); sc.nextLine();
                        if (tarefaRet < tarefasAtrasadas.size() && tarefaRet > 0) {
                            Tarefa tarefaSeleccionada = tarefasAtrasadas.get(tarefaRet);
                            System.out.println("Descrición: " + tarefaSeleccionada.getDescricion());
                            System.out.println("Data introdución: " + tarefaSeleccionada.getDataIntroducion());
                            System.out.println("Data límite: " + tarefaSeleccionada.getDataLimite());
                        } else
                            System.out.println("Non existe a tarefa seleccionada");
                    }

                    // Sair
                    case "s" -> {
                        // marcamos o menú número 1
                        menu = 1;
                        usuarioActivo = Optional.empty(); // Quitamos o usuario activo
                    }
                    
                    // Opción por defecto
                    default -> System.out.println("Introduza unha opción válida");
                }
            }
        }

        sc.close();

    }
}
