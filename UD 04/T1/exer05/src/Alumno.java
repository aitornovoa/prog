public class Alumno {
    private static int NUMEXPEDIENTESIGUIENTE = 101;

    private String nombre;
    private String apellidos;
    private double[] notas;
    private boolean[] notasAnhadidas;
    private String numExpediente;

    /**
     * Constructor de la clase Alumno
     * @param nombre Nombre del alumno
     * @param apellidos Apellidos del alumno
     */
    public Alumno(String nombre, String apellidos) {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        
        // Asignamos el número de expediente actual y lo incrementamos para el siguiente
        this.numExpediente = String.valueOf(Alumno.NUMEXPEDIENTESIGUIENTE);
        NUMEXPEDIENTESIGUIENTE++;

        // Inicializamos notas y marcamos que ninguna ha sido añadida
        notas = new double[3];
        notasAnhadidas = new boolean[3];
        for (int i = 0; i < notasAnhadidas.length; i++) {
            notasAnhadidas[i] = false;
        }
    }

    /**
     * Asigna la nota del primer trimestre
     * @param nota Nota entre 0 y 10
     */
    public void setNota1Trimestre(double nota) {
        this.setNotaTrimestre(nota, 0);
    }

    /**
     * Asigna la nota del segundo trimestre
     * @param nota Nota entre 0 y 10
     */
    public void setNota2Trimestre(double nota) {
        this.setNotaTrimestre(nota, 1);
    }

    /**
     * Asigna la nota del tercer trimestre
     * @param nota Nota entre 0 y 10
     */
    public void setNota3Trimestre(double nota) {
        this.setNotaTrimestre(nota, 2);
    }

    /**
     * Método privado para asignar una nota a un trimestre
     * @param nota Nota entre 0 y 10
     * @param trimestre Índice del trimestre (0, 1 o 2)
     */
    private void setNotaTrimestre(double nota, int trimestre) {
        if (nota >= 0 && nota <= 10) {
            this.notas[trimestre] = nota;
            this.notasAnhadidas[trimestre] = true;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    /**
     * Calcula la media de las notas ingresadas
     * @return La nota media o 0.0 si no hay notas
     */
    public double getMedia() {
        int numNotas = 0;
        double sumaNotas = 0;
        
        for (int i = 0; i < notasAnhadidas.length; i++) {
            if (notasAnhadidas[i]) {
                numNotas++;
                sumaNotas += notas[i];
            }
        }
        
        return (numNotas > 0) ? (sumaNotas / 3) : 0.0;
    }

    /**
     * Determina si el alumno está aprobado
     * @return true si tiene todas las notas ingresadas y la media es mayor o igual a 5, false en caso contrario
     */
    public boolean estaAprobado() {
        for (int i=0;i<notasAnhadidas.length;i++) {
            if (!notasAnhadidas[i]) {
                return false;
            }
        }
        return this.getMedia() >= 5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(apellidos).append(", ").append(nombre)
          .append(" con exp. ").append(numExpediente)
          .append(" con nota ").append(getMedia());
        return sb.toString();
    }
}
