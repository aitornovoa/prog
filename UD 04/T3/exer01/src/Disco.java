
public class Disco {

    private String titulo;
    private Grupo grupo;
    private int anho;
    private int numCanciones;

    public Disco(String titulo, Grupo grupo, int anho, int numCanciones){
        this.setTitulo(titulo);
        this.setGrupo(grupo);
        this.setAnho(anho);
        this.setTitulo(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public int calcularAnhosExistencia(){
        int anhosExistencia = this.anho-this.grupo.getAnho();
        return anhosExistencia;
    }

}
