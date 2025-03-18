public class App {
    public static void main(String[] args) throws Exception {
        
        Grupo raiz = new Grupo("La raíz", "España", 2006);
        Disco poetas = new Disco("Entre poetas y presos", raiz, 2016, 15);
        System.out.println(raiz.getNombre()+" se fundó hace "+raiz.getEdad());
        System.out.println("Pasaron "+poetas.calcularAnhosExistencia()+ " años entre la creación del grupo "+raiz.getNombre()+" y el lanzamiento del disco "+poetas.getTitulo());
    }
}
