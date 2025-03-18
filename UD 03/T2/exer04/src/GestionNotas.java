import java.util.Scanner;

public class GestionNotas {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        //Indicar numero estudiantes
        System.out.println("Introduce el numero de estudiantes:");
        int numEstudiantes = read.nextInt();

        //Indicar numero de modulos
        System.out.println("Introduce el numero de modulos:");
        int numModulos = read.nextInt();

        //Creación de la matriz notas para añadir notas a cada alumno en su correspondiente modulo
        double[][] notas = new double[numEstudiantes][numModulos];
        for (int i=0;i < numEstudiantes;i++){
            for (int j=0;j < numModulos;j++){
                while (true) {
                    System.out.printf("Introduce la nota del estudiante %d en el modulo %d (0-10): ", i + 1, j + 1);
                    double nota = read.nextDouble();
                    if (nota >= 0 && nota <= 10) {
                        notas[i][j] = nota;
                        break;
                    }
                    System.out.println("Nota no válida. Debe estar entre 0 y 10.");
                }
            }
        }
        
        //Visualiazación del menú, junto el switch para cada opcion
        while (true) {
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("a) Media alumno");
            System.out.println("b) Porcentaje de aprobados");
            System.out.println("c) Salir\n");
            System.out.println("Introduce una opcion:");
            char opcion = read.next().charAt(0);

            switch(opcion){
                case 'a':
                    System.out.println("Introduce el indice del alumno: ");
                    int indiceAlumno = read.nextInt();
                    if (indiceAlumno>=0 && indiceAlumno<numEstudiantes){
                        double suma = 0;
                        for (int j=0;j < numModulos;j++){
                            suma += notas[indiceAlumno][j];
                        }
                        double media = suma/numModulos;
                        System.out.println("La media es "+media+"\n");
                    }
                    else{
                        System.out.println("Índice de alumno no válido.\n");
                    }
                    break;
                case 'b':
                    System.out.println("Introduce el indice del módulo: ");
                    int indiceModulo = read.nextInt();
                    if (indiceModulo>=0 && indiceModulo<numModulos){
                        int aprobados = 0;
                        for (int i=0;i < numEstudiantes;i++){
                            if (notas[i][indiceModulo]>=5){
                                aprobados++;
                            }
                        }
                        double porcentajeAprobados = (aprobados*100)/numEstudiantes;
                        System.out.println("El porcentaje de aprobados es " + porcentajeAprobados +"%\n");
                    }
                    else{
                        System.out.println("Índice de módulo no válido.\n");
                    }
                    break;
                case 'c': 
                    read.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.\n");
            
            }
        }
    }    
}
